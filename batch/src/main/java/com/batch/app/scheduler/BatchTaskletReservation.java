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

import java.util.Iterator;
import java.util.List;

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

        List<ReservationWithEmail> listResa = bookClient.getListReservationWithEmailAndBook();

        Iterator<ReservationWithEmail> it2 = listResa.iterator();
        while (it2.hasNext()) {
            ReservationWithEmail resa = it2.next();
            mail.send(resa);
        }

        return RepeatStatus.FINISHED;
    }

}
