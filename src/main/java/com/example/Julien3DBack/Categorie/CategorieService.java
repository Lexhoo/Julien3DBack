package com.example.Julien3DBack.Categorie;

import com.example.Julien3DBack.Projet.ProjetService;
import com.example.Julien3DBack.exceptionHandler.DataNotFoundException;
import com.example.Julien3DBack.exceptionHandler.DataSystemException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategorieService {

    private static final Logger LOG = LogManager.getLogger(ProjetService.class);

    @Autowired CategorieRepository categorieRepository;

    public List<Categorie> getAllCategories() {
        List<Categorie> categorieList;
        try {
            categorieList = this.categorieRepository.findAll();
            if (categorieList.isEmpty()) {
                throw new DataNotFoundException("0200");
            }
            }catch (Exception e) {
                if (e.getMessage().equals("0200")) {
                    throw new DataNotFoundException("0200", e);
                } else {
                    LOG.error("Une erreur est survenue lors de l'appel BDD getAllProjets", e);
                    throw new DataSystemException("0300", e);
                }

                }
            return categorieList;
           }



    public Optional<Categorie> getCategorieById(Long id) { return categorieRepository.findById(id); }

    public Categorie createCategorie(Categorie categorie) {
        Categorie categorie1;
        try {
            categorie1 = this.categorieRepository.save(categorie);
        } catch (Exception e) {
            LOG.error("Une erreur est survenue lors de l'appel BDD createCategorie", e);
            throw new DataSystemException("0301, e");
        }
        return categorie1;
    }

    public Categorie updateCategorie(Categorie categorie, long id) {
        try {
            Optional<Categorie> studentOptional = this.categorieRepository.findById(id);

            if (!studentOptional.isPresent()) {
                throw new DataNotFoundException("0201");
            }
            categorie.setId(id);
            categorie = this.categorieRepository.save(categorie);
        } catch (Exception e) {
            if (e.getMessage().equals("0201")) {
            } else {
                LOG.error("Une erreur est survenue lors de l'appel BDD updateCategorie", e);
                throw new DataSystemException("0302", e);
            }
        }
            return categorie;
        }


    public void deleteCategorieById(Long id) {
            try {
                this.categorieRepository.deleteById(id);
            } catch (Exception e) {
                LOG.error("Une erreur est survenue lors de l'appel BDD deleteCategorieById", e);
                throw new DataSystemException("0303", e);
            }
        }

        public Categorie getCategorieByName(String name) {
        Categorie categorie;
        try{
            categorie = this.categorieRepository.findByname(name);
            if (categorie == null) {
                throw new DataNotFoundException("0202");
             }
            } catch (Exception e) {
                if (e.getMessage().equals("0202")) {
                    throw new DataNotFoundException("0202, e");
                } else {
                LOG.error("Une erreur est survenue lors de l'appel BDD getCategorieByName", e);
                throw new DataSystemException("0304", e);
            }
        }
        return categorie;
        }
  }
