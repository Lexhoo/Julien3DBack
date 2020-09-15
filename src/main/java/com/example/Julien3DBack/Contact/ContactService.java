package com.example.Julien3DBack.Contact;

import com.example.Julien3DBack.Categorie.Categorie;
import com.example.Julien3DBack.Categorie.CategorieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContactService {

    @Autowired
    ContactRepository repository;

    public List<Contact> findAll() {
        return repository.findAll();
    }

    public Contact create(Contact contact) {
        return repository.save(contact);
    }

    public Contact updateContact(Contact contact) {
        return repository.save(contact);
    }

    public void deleteById (Long id) {
        repository.deleteById(id);
    }
}
