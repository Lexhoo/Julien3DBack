package com.example.Julien3DBack.Contact;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/contact")
public class ContactController {

    @Autowired ContactRepository contactRepository;
    @GetMapping()
    public List<Contact> getAll(){
        return contactRepository.findAll();
    }
}
