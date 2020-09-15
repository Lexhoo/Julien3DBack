package com.example.Julien3DBack.Projet;

import com.example.Julien3DBack.Categorie.Categorie;
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

@RestController
@CrossOrigin
@RequestMapping("/projets")

public class ProjetController {

    @Autowired ProjetService projetService;


    @GetMapping()
    public List<Projet> getAllProjets() {
        return projetService.getAllProjets();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Projet> getProjetDataByID(@PathVariable("id") long projet_id) {
        Optional<Projet> projetData = projetService.getProjetById(projet_id);

        if (projetData.isPresent()) {
            return new ResponseEntity<>(projetData.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/post")
    public Projet save(@RequestBody Projet projet) {
        return projetService.createProjet(projet);
    }

    @ExceptionHandler(NotFoundException.class)
    @PutMapping("/update/{id}")
    public ResponseEntity<Projet> updateProjet(@RequestBody Projet projet, @PathVariable long id) throws NotFoundException {
        return new ResponseEntity<Projet>(this.projetService.updateProjet(projet, id), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteProjet(@PathVariable("id") long id, Model model) {
        Projet projet = projetService.getProjetById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid Projet Id:" + id));
        projetService.deleteProjetById(id);
        model.addAttribute("projet", projetService.getAllProjets());
        return "index";
    }
}
