package com.example.Julien3DBack.Categorie;

import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin
@RequestMapping("/categories")
public class CategorieController {

    @Autowired CategorieService categorieService;

    @GetMapping()
    public List<Categorie> getAll() {
        return categorieService.getAllCategories();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Categorie> getCategorieDataByID(@PathVariable("id") long categorie_id) {
        Optional<Categorie> categorieData = categorieService.getCategorieById(categorie_id);

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
    public void deleteCategorie(@PathVariable("id") long id) {
      this.categorieService.deleteById(id);
    }
}
