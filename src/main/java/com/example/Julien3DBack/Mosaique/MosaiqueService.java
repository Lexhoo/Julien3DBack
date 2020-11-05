package com.example.Julien3DBack.Mosaique;

import com.example.Julien3DBack.Projet.Projet;
import com.example.Julien3DBack.Projet.ProjetService;
import com.example.Julien3DBack.UploadImage.UploadImage;
import com.example.Julien3DBack.UploadImage.UploadImageService;
import com.example.Julien3DBack.exceptionHandler.DataNotFoundException;
import com.example.Julien3DBack.exceptionHandler.DataSystemException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

@Service
public class MosaiqueService {

    private static final Logger LOG = LogManager.getLogger(MosaiqueService.class);

    @Autowired
    private ProjetService projetService;

    @Autowired
    private UploadImageService uploadImageService;

    public List<UploadImage> getImagesCategorieByProjet(Long idCategorie) {
        List<UploadImage> imagesList = new ArrayList<>();
        try {
            /**
             * On récupère la liste d'images d'une seule catégorie grâce à son id.
             */
            List<UploadImage> imagesListByCategorie = this.uploadImageService.getImagesByIdCategorie(idCategorie);

            /**
             * On récupère toute la liste des projets.
             */
            List<Projet> projetList = projetService.getAllProjets();
            /**
             * On boucle sur la liste des projets récupérée.
             */
            if (projetList != null && !projetList.isEmpty()) {
                projetList.stream().forEach(projet -> {
                    /**
                     * On filtre sur la liste d'images de la catégorie récupérée en premier de manière à n'avoir que les
                     * images dont l'idProjet est égale à celui du projet de la boucle (image.getIdProjet() == projet.getId()).
                     */
                    List<UploadImage> listeImagesTemporaire = imagesListByCategorie.stream()
                            .filter(image -> projet.getId().equals(image.getIdProjet())).collect(Collectors.toList());
                    if (listeImagesTemporaire != null && !listeImagesTemporaire.isEmpty()) {


                        Random random = new Random();
                        /**
                         * On récupère une image au hasard de cette liste pour l'ajouter à celle que l'on envoie au front.
                         */
                        imagesList.add(listeImagesTemporaire.get(random.nextInt(listeImagesTemporaire.size())));
                    }
                });
            }
        } catch (Exception e) {
            LOG.error("Une erreur est survenue lors de la constitution du randhome", e);
            throw new DataSystemException("0310", e);
        }
        return imagesList;
    }

    public List<UploadImage> getImageRandomByprojets() {
        List<UploadImage> imagesList = new ArrayList<>();
        try {

            List<Projet> projetList = projetService.getAllProjets();
            if (projetList != null && !projetList.isEmpty()) {
                projetList.stream().forEach(projet -> {
                    List<UploadImage> imagesForRandomList = uploadImageService.getImagesByIdProjet(projet.getId());
                    if (imagesForRandomList != null && !imagesForRandomList.isEmpty()) {
                        Random random = new Random();
                        UploadImage uploadImage = imagesForRandomList.get(random.nextInt(imagesForRandomList.size()));
                        uploadImage.setProjetName(projet.getName());
                        imagesList.add(uploadImage);
                    }
                });
            }
        } catch (Exception e) {

            if ("0200".equals(e.getMessage()) || "0206".equals(e.getMessage())) {
                throw new DataNotFoundException("207", e);
            } else {
                LOG.error("Une erreur est survenue lors de la constitution du randhome", e);
                throw new DataSystemException("0310", e);
            }
        }
        return imagesList;

    }
}
