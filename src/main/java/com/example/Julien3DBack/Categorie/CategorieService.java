package com.example.Julien3DBack.Categorie;

import com.example.Julien3DBack.Projet.Projet;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategorieService {

    @Autowired CategorieRepository categorieRepository;

    public List<Categorie> getAllCategories() {
        return categorieRepository.findAll();
    }

    public Optional<Categorie> getCategorieById(Long id) { return categorieRepository.findById(id); }

    public Categorie create(Categorie categorie) {
        return categorieRepository.save(categorie);
    }

    public Categorie updateCategorie(Categorie categorie, long id) throws NotFoundException {

        Optional<Categorie> studentOptional = categorieRepository.findById(id);

        if (!studentOptional.isPresent()) {
            throw new NotFoundException("Catégorie non trouvé");
        }
        categorie.setId(id);

        return categorieRepository.save(categorie);
    }

    public void deleteById (Long id) {
        categorieRepository.deleteById(id);
    }
}
