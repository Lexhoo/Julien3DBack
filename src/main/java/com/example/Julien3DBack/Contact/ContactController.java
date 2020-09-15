package com.example.Julien3DBack.Contact;

import com.example.Julien3DBack.Categorie.Categorie;
import com.example.Julien3DBack.Categorie.CategorieRepository;
import com.example.Julien3DBack.Categorie.CategorieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin
@RequestMapping("/contacts")
public class ContactController {

    @Autowired
    ContactService contactService;

    @Autowired
    ContactRepository repository;

    @GetMapping()
    public List<Contact> getAll() {
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Contact> getContactDataByID(@PathVariable("id") long contact_id) {
        Optional<Contact> contactData = repository.findById(contact_id);

        if (contactData.isPresent()) {
            return new ResponseEntity<>(contactData.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/post")
    public Contact save(@RequestBody Contact contact) {
        return contactService.create(contact);
    }

    @PutMapping("/update/{id}")
    public Contact contact(@RequestBody Contact contact) {
        return contactService.updateContact(contact);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteContact(@PathVariable("id") long id, Model model) {
        Contact contact = repository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid Contact Id:" + id));
        repository.delete(contact);
        model.addAttribute("contact", repository.findAll());
        return "index";
    }
}
