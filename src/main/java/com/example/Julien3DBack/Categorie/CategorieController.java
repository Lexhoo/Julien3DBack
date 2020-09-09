package com.example.Julien3DBack.Categorie;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/category")
public class CategorieController {

    @Autowired CategorieRepository categorieRepository;
    @GetMapping()
    public List<Categorie> getAll() {
        return categorieRepository.findAll();
    }


}
