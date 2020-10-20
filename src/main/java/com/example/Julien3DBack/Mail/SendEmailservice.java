package com.example.Julien3DBack.Mail;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class SendEmailservice {

    private JavaMailSender javaMailSender;

    @Autowired
    public SendEmailservice(JavaMailSender javaMailSender){
        this.javaMailSender = javaMailSender;
    }

    public void sendEmail(Mail mail) {

        StringBuilder corpsMail = new StringBuilder(mail.getMessage());
        StringBuilder subject = new StringBuilder(mail.getNom());

        SimpleMailMessage msg = new SimpleMailMessage();
        msg.setTo("lexhoo@yahoo.fr", "julien.adoum@gmail.com");
        msg.setFrom(mail.getEmail());

        msg.setSubject(subject.append(" Contact : ").append(mail.getPhone()).toString());
        msg.setText(corpsMail
                .append("\n")
                .append("\n")
                .append("nom de la société : ").append(mail.getCompagny()).
                        append("\n").append("mail : ").append(mail.getEmail())
                .append("\n").append(" Contact : ").append(mail.getPhone())
                .toString());

        this.javaMailSender.send(msg);

    }


}
