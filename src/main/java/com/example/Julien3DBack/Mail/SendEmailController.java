package com.example.Julien3DBack.Mail;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/mail")
public class SendEmailController {

    @Autowired
    SendEmailservice sendEmailservice;

    @PostMapping(value = "/post")
    public void sendMail(@RequestBody Mail mail){
        this.sendEmailservice.sendEmail(mail);
    }
}
