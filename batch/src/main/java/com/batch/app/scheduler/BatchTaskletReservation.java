package com.batch.app.scheduler;

import com.batch.app.mail.MailBookAvailable;
import com.library.oc.library.business.contract.manager.BookClient;
import com.library.oc.library.business.contract.manager.BookService;
import com.library.oc.library.business.contract.manager.ReservationWithEmail;
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

    @Value("${batch.message2}")
    private String message;

    @Autowired
    private MailBookAvailable mail;

    public RepeatStatus execute(StepContribution contribution, ChunkContext chunkContext) throws Exception {
        System.out.println(message);

        BookService bookService = new BookService();
        BookClient bookClient = bookService.getBookPort();

        List<ReservationWithEmail> firstListResa = bookClient.getListReservationWithEmailAndBook();

        Iterator<ReservationWithEmail> it2 = firstListResa.iterator();
        while (it2.hasNext()) {
            ReservationWithEmail resa = it2.next();
            mail.send(resa);

        }
        return RepeatStatus.FINISHED;
    }

}
