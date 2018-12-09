package com.batch.app.scheduler;

import com.batch.app.mail.MailLate;
import com.batch.app.mail.MailBookAvailable;
import com.library.oc.library.business.contract.manager.*;
import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

import java.util.*;
import java.util.Date;
import java.util.concurrent.TimeUnit;

@Component
public class BatchTaskletReservation implements Tasklet {

    @Value("${batch.message}")
    private String message;

    @Autowired
    private MailBookAvailable mail;

    public RepeatStatus execute(StepContribution contribution, ChunkContext chunkContext) throws Exception {
        System.out.println(message);

        BookService bookService = new BookService();
        BookClient bookClient = bookService.getBookPort();

        // 1st list : list of all resa active
        List<ReservationWithEmail> firstListResa = bookClient.getListReservationWithEmailAndBook();

        // 2nd list : list of resa without resa older than 48hours :
        List<ReservationWithEmail> secondListResa = new ArrayList<ReservationWithEmail>();


        for (ReservationWithEmail reservation : firstListResa) {
            // 1 : for each reservation, we check that we never send an email (and so the reservation is still active)
            Boolean emailAlreadySend = reservation.isEmailSend();

            if (!emailAlreadySend) {
                // 2 : for each reservation, if we never send an email, we add the resa to the secondListResa (the email batch list)
                secondListResa.add(reservation);
                // 3 and we update the status of their email (alreadySend to true)
                bookClient.updateEmailStatus(reservation.getId());
            }
            else {   // if we already send an email, we check that it's not older than 48hours
                // dateSend = datetime when the email was send
                Date dateSend = (reservation.getDateOfEmail()).toGregorianCalendar().getTime();

                // get current date
                DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
                Date currentDate = new Date();

                System.out.println(dateFormat.format(dateSend));
                System.out.println(dateFormat.format(currentDate));

                // check delta time between 1st email send and now
                TimeUnit timeUnit = null;

                long deltaInMilliseconds = currentDate.getTime() - dateSend.getTime();
                System.out.println(deltaInMilliseconds);

                // 2 days in milliseconds is 1,728^8, if delta > to this, then the reservation has more than 2 days
                // -> so the resa is not active anymore
                if (deltaInMilliseconds > 172800000) {
                    // 1 : update status reservation "active" to "false" => next person on the list
                    bookClient.updateReservationStatusToFalse(reservation.getId());
                }
                else {
                    secondListResa.add(reservation);
                }
            }
        }

        Iterator<ReservationWithEmail> it2 = secondListResa.iterator();
        while (it2.hasNext()) {
            ReservationWithEmail resa = it2.next();
            mail.send(resa);

        }
        return RepeatStatus.FINISHED;
    }

}
