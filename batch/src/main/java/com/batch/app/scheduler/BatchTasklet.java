package com.batch.app.scheduler;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.library.oc.library.business.contract.manager.User;
import com.library.oc.library.business.contract.manager.UserClient;
import com.library.oc.library.business.contract.manager.UserService;
import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.batch.app.mail.ApacheMail;

@Component
public class BatchTasklet implements Tasklet {

    @Value("${batch.message}")
    private String message;

    @Autowired
    private ApacheMail mail;

    public RepeatStatus execute(StepContribution contribution, ChunkContext chunkContext) throws Exception {
        System.out.println(message);

        UserService userService = new UserService();
        UserClient userClient = userService.getUserPort();

        List<User> listUser = userClient.getListUserLateReturn();

        Iterator<User> it2 = listUser.iterator();
        while (it2.hasNext()) {
            User user = it2.next();
            mail.send(user);
        }

        return RepeatStatus.FINISHED;
    }

}
