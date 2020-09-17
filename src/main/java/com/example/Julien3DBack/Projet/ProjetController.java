package com.example.Julien3DBack.Projet;

import com.example.Julien3DBack.Categorie.Categorie;
import com.example.Julien3DBack.Categorie.CategorieService;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.ExecutionException;

@RestController
public class ProjetController {

    @Autowired
    ProjetService projetService;

    @GetMapping("/getProjet")
    public Projet projet(@RequestParam String name ) throws InterruptedException, ExecutionException {
        return projetService.getProjetDetails(name);
    }

    @PostMapping("/createProjet")
    public String createProjet(@RequestBody Projet projet ) throws InterruptedException, ExecutionException {
        return projetService.saveProjetDetails(projet);
    }

    @PutMapping("/updateProjet")
    public String updateProjet(@RequestBody Projet projet  ) throws InterruptedException, ExecutionException {
        return projetService.updateProjetDetails(projet);
    }

    @DeleteMapping("/deleteProjet")
    public String deleteProjet(@RequestParam String name){
        return projetService.deleteProjet(name);
    }
}
