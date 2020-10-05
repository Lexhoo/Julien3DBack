package com.example.Julien3DBack.Projet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/projets")

public class ProjetController {

    @Autowired
    ProjetService projetService;

    @GetMapping()
    public List<Projet> getAllProjets() {
        return this.projetService.getAllProjets();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Projet> getProjetDataByID(@PathVariable long id) {
        return new ResponseEntity<Projet>(projetService.getProjetById(id), HttpStatus.OK);
    }

    @GetMapping("name/{name}")
    public ResponseEntity<Projet> getProjetDataByID(@PathVariable String name) {
        return new ResponseEntity<Projet>(projetService.getProjetsByName(name), HttpStatus.OK);
    }

    @PostMapping("/post")
    public Projet save(@RequestBody Projet projet) {
        return projetService.createProjet(projet);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Projet> updateProjet(@RequestBody Projet projet, @PathVariable long id) {
        return new ResponseEntity<Projet>(this.projetService.updateProjet(projet, id), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteProjet(@PathVariable long id) {
        this.projetService.deleteProjetById(id);
    }
}
