package com.example.connection.controller;

import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

@Service
public class EmailController {
    public void sendMail(String recipiente,String link,String nome,String apelido){
        Properties props = new Properties();
        props.put("mail.smtp.auth","true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.ssl.enable", "true");
        props.put("mail.smtp.port", "465");
        Session session = Session.getInstance(props, null);

        try {
            MimeMessage msg = new MimeMessage(session);
            msg.setFrom("me@example.com");
            msg.setRecipients(Message.RecipientType.TO,
                    recipiente);
            msg.setSubject("Account, MarquesExpress");
            msg.setSentDate(new Date());
            msg.setText("A sua conta na MarquesExpress foi criada com sucesso!!\n" +
                    "Bem vindo "+nome+" "+apelido+"\n" +
                    "Espero que se divirta.");
            System.out.println("Aqui?");
            Transport.send(msg, "marquesjr898@gmail.com", "hqcwyopcdmiduarf");
        } catch (MessagingException mex) {
            System.out.println("send failed, exception: " + mex);
        }
        System.out.println("mandou");
    }
//    email132Sender132@gmail.com
//    emailsender132
}
