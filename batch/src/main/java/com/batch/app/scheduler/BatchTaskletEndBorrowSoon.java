package com.batch.app.scheduler;

import com.batch.app.mail.MailRemindEndBorrowSoon;
import com.library.oc.library.business.contract.manager.BookBorrowedWithEmail;
import com.library.oc.library.business.contract.manager.BookClient;
import com.library.oc.library.business.contract.manager.BookService;
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
public class BatchTaskletEndBorrowSoon implements Tasklet{

        @Value("${batch.message3}")
        private String message;

        @Autowired
        private MailRemindEndBorrowSoon mail;

        public RepeatStatus execute(StepContribution contribution, ChunkContext chunkContext) throws Exception {
            System.out.println(message);

            BookService bookService = new BookService();
            BookClient bookClient = bookService.getBookPort();

            List<BookBorrowedWithEmail> listBorrowEndSoon = bookClient.getListBookBorrowedFinishInFiveDays();

            Iterator<BookBorrowedWithEmail> it = listBorrowEndSoon.iterator();
            while (it.hasNext()) {

                BookBorrowedWithEmail borrow = it.next();
                mail.send(borrow);
            }

            return RepeatStatus.FINISHED;
        }

    }
