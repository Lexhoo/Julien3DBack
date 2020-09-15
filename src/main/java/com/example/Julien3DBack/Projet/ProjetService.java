package com.example.Julien3DBack.Projet;

import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProjetService {

    @Autowired
    ProjetRepository repository;

    public List<Projet> getAllProjets() {
        return repository.findAll();
    }

    public Projet createProjet(Projet projet) {
        return repository.save(projet);
    }

    public Projet updateProjet(Projet projet, long id) throws NotFoundException {

        Optional<Projet> studentOptional = repository.findById(id);

        if (!studentOptional.isPresent()) {
            throw new NotFoundException("projet non trouvé");
        }
        projet.setId(id);

        return repository.save(projet);
    }

    public Optional<Projet> getProjetById(Long id) {
        return repository.findById(id);
    }

    public void deleteProjetById(Long id) {
        repository.deleteById(id);
    }

    public List<Projet> getProjetsByName(String name) {
        return repository.findByName(name);
    }
}
