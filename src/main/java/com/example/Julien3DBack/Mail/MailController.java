package com.example.Julien3DBack.Mail;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/mail")
public class MailController {

    @Autowired MailRepository mailRepository;
    @GetMapping()
    public List<Mail> getAll(){
        return mailRepository.findAll();
    }
}
