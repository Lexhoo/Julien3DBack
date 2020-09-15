package com.example.Julien3DBack.Categorie;

import com.example.Julien3DBack.Projet.Projet;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin
@RequestMapping("/categories")
public class CategorieController {

    @Autowired CategorieService categorieService;

    @Autowired CategorieRepository categorieRepository;

    @GetMapping()
    public List<Categorie> getAll() {
        return categorieRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Categorie> getCategorieDataByID(@PathVariable("id") long categorie_id) {
        Optional<Categorie> categorieData = categorieRepository.findById(categorie_id);

        if (categorieData.isPresent()) {
            return new ResponseEntity<>(categorieData.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/post")
    public Categorie save(@RequestBody Categorie categorie) {
        return categorieService.create(categorie);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Categorie> updateCategorie(@RequestBody Categorie categorie, @PathVariable long id) throws NotFoundException {
        return new ResponseEntity<Categorie>(this.categorieService.updateCategorie(categorie, id), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteCategorie(@PathVariable("id") long id, Model model) {
        Categorie categorie = categorieRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid Categorie Id:" + id));
        categorieRepository.delete(categorie);
        model.addAttribute("categorie", categorieRepository.findAll());
        return "index";
    }
}
