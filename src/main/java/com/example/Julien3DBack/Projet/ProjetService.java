package com.example.Julien3DBack.Projet;

import com.example.Julien3DBack.exceptionHandler.DataNotFoundException;
import com.example.Julien3DBack.exceptionHandler.DataSystemException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProjetService {

    private static final Logger LOG = LogManager.getLogger(ProjetService.class);

    @Autowired
    ProjetRepository repository;

    /**
     * Méthode permettant de récupérer tous les projets.
     *
     * @return une liste de projets.
     */
    public List<Projet> getAllProjets() {
        List<Projet> projetList;
        try {
            projetList = this.repository.findAll();
            if (projetList.isEmpty()) {
                throw new DataNotFoundException("0200");
            }
        } catch (Exception e) {
            if (e.getMessage().equals("0200")) {
                throw new DataNotFoundException("0200", e);
            } else {
                LOG.error("Une erreur est survenue lors de l'appel BDD getAllProjets", e);
                throw new DataSystemException("0300", e);
            }
        }
        return projetList;
    }

    /**
     * Méthode permettant de créer un projet.
     *
     * @param projet
     * @return le projet créé.
     */
    public Projet createProjet(Projet projet) {
        Projet projet1;
        try {
            projet1 = this.repository.save(projet);
        } catch (Exception e) {
            LOG.error("Une erreur est survenue lors de l'appel BDD createProjet", e);
            throw new DataSystemException("0301", e);
        }
        return projet1;
    }

    /**
     * Méthode permettant de mettre à jour un projet.
     *
     * @param projet
     * @param id
     * @return le projet mis à jour.
     */
    public Projet updateProjet(Projet projet, long id) {
        try {
            Optional<Projet> studentOptional = this.repository.findById(id);

            if (!studentOptional.isPresent()) {
                throw new DataNotFoundException("0201");
            }
            projet.setId(id);
            projet = this.repository.save(projet);
        } catch (Exception e) {
            if (e.getMessage().equals("0201")) {
                throw new DataNotFoundException("0201", e);
            } else {
                LOG.error("Une erreur est survenue lors de l'appel BDD updateProjet", e);
                throw new DataSystemException("0302", e);
            }
        }
        return projet;
    }

    /**
     * Méthode permettant de récupérer un projet grâce à son id.
     *
     * @param id
     * @return un projet.
     */
    public Projet getProjetById(Long id) {
        Optional<Projet> projet;
        try {
            projet = this.repository.findById(id);
            if (!projet.isPresent()) {
                throw new DataNotFoundException("0203");
            }

        } catch (Exception e) {
            if (e.getMessage().equals("0203")) {
                throw new DataNotFoundException("0203", e);
            } else {
                LOG.error("Une erreur est survenue lors de l'appel BDD getProjetById", e);
                throw new DataSystemException("0305", e);
            }
        }
        return projet.get();
    }

    public void deleteProjetById(Long id) {
        try {
            this.repository.deleteById(id);
        } catch (Exception e) {
            LOG.error("Une erreur est survenue lors de l'appel BDD deleteProjetById", e);
            throw new DataSystemException("0303", e);
        }
    }

    /**
     * Méthode permettant de récupérer un projet grâce à son nom.
     *
     * @param name
     * @return un projet.
     */
    public Projet getProjetsByName(String name) {
        Projet projet;
        try {
            projet = this.repository.findByName(name);
            if (projet == null) {
                throw new DataNotFoundException("0202");
            }
        } catch (Exception e) {
            if (e.getMessage().equals("0202")) {
                throw new DataNotFoundException("0202", e);
            } else {
                LOG.error("Une erreur est survenue lors de l'appel BDD getProjetsByName", e);
                throw new DataSystemException("0304", e);
            }
        }
        return projet;
    }
}
