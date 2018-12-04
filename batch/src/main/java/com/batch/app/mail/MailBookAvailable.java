package com.batch.app.mail;

import java.net.MalformedURLException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Iterator;
import java.util.List;

import com.library.oc.library.business.contract.manager.User;
import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.HtmlEmail;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class MailBookAvailable {

    @Value("${batch.mail}")
    private String mail;

    @Value("${batch.password}")
    private String password;

    public void send(User user) {
        // Create the email message


        HtmlEmail email = new HtmlEmail();

        email.setHostName("smtp.googlemail.com");
        email.setSmtpPort(587);
        email.setAuthenticator(new DefaultAuthenticator(mail, password));
        email.setSSLOnConnect(true);
        try {
            email.addTo(user.getEmail(), user.getSurname());
            email.setFrom(mail, "Moi");
            email.setSubject("Ouvrage de nouveau disponible");

            // set the html message

            String message = "<html>Bonjour " + user.getSurname();
            message += "<br>Vous recevez cet email suite à la réservation d'un ouvrage auprès de notre Bibliothèque.<br>";
            message += "<br>Nous avons le plaisir de vous informer que cet ouvrage est à nouveau disponible<br>";
            message += "<br>Vous avez 48H pour venir le récupérer, passé ce délai, votre réservation sera annulée<br>";
            message += "<br>Cordialement<br>";

            email.setHtmlMsg(message);

            // set the alternative message
            email.setTextMsg("Your email client does not support HTML messages");

            // send the email
            email.send();
            System.out.println("Mail for return booked has been sent successfully");
        } catch (EmailException e) {
            System.out.println("Unable to send an email" + e.getMessage());
        }

    }
}


