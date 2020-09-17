package com.example.Julien3DBack.Categorie;

import com.example.Julien3DBack.DatasFiles.DatasFiles;
import com.example.Julien3DBack.Projet.Projet;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.ExecutionException;

@RestController
public class CategorieController {

    @Autowired CategorieService categorieService;

    @GetMapping("/getCategorie")
    public Categorie categorie(@RequestParam String name ) throws InterruptedException, ExecutionException {
        return categorieService.getCategorieDetails(name);
    }

    @PostMapping("/createCategorie")
    public String createCategorie(@RequestBody Categorie categorie ) throws InterruptedException, ExecutionException {
        return categorieService.saveCategorieDetails(categorie);
    }

    @PutMapping("/updateCategorie")
    public String updateCategorie(@RequestBody Categorie categorie  ) throws InterruptedException, ExecutionException {
        return categorieService.updateCategorieDetails(categorie);
    }

    @DeleteMapping("/deleteCategorie")
    public String deleteCategorie(@RequestParam String name){
        return categorieService.deleteCategorie(name);
    }
}
