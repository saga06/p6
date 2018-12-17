package com.batch.app.mail;

import com.library.oc.library.business.contract.manager.BookBorrowedWithEmail;
import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.HtmlEmail;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.time.format.DateTimeFormatter;

@Component
public class MailRemindEndBorrowSoon {

        @Value("${batch.mail}")
        private String mail;

        @Value("${batch.password}")
        private String password;

        public void send(BookBorrowedWithEmail borrow) {

            HtmlEmail email = new HtmlEmail();

            email.setHostName("smtp.googlemail.com");
            email.setSmtpPort(587);
            email.setAuthenticator(new DefaultAuthenticator(mail, password));
            email.setSSLOnConnect(true);
            try {
                email.addTo(borrow.getEmail(), "Lecteur");
                email.setFrom(mail, "Bibliotheque OC");
                email.setSubject("La fin de votre emprunt approche !");

                // set the html message

                String message = "<html>Bonjour " +borrow.getLastname()+ " " +borrow.getSurname()+ "<br>";
                message += "<br>Vous recevez cet email parce qu'il reste 5 jours, ou moins, pour retourner l'ouvrage \"" +borrow.getBookTitle()+ "\" aupr&egrave;s de notre Biblioth&egrave;que.<br>";
                message += "<br>Pour rappel, la date limite de retour de votre pr&ecirc;t est le : " +borrow.getDateEnd().toGregorianCalendar().toZonedDateTime().format( DateTimeFormatter.ofPattern( "dd/MM/uuuu" ) )+ ".<br>";
                message += "<br>Merci de respecter la date limite, ou de prolonger votre emprunt via votre espace personnel.<br>";
                message += "<br>Cordialement<br>";
                message += "<br>Votre Biblioth&egrave;que OC<br>";



                email.setHtmlMsg(message);

                // set the alternative message
                email.setTextMsg("Your email client does not support HTML messages");

                // send the email
                email.send();
                System.out.println("Mail for remind the end of the borrw in a few days has been sent successfully to " +borrow.getEmail()+ "");
            }
            catch (EmailException e) {
                System.out.println("Unable to send an email" + e.getMessage());
            }
        }
    }

