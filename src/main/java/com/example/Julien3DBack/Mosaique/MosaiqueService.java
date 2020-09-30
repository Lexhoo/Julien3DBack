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
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
public class MosaiqueService {

    private static final Logger LOG = LogManager.getLogger(MosaiqueService.class);

    @Autowired
    private ProjetService projetService;

    @Autowired
    private UploadImageService uploadImageService;

    @Cacheable
    public List<UploadImage> getImageRandomByprojets() {
        List<UploadImage> imagesList = new ArrayList<>();
        try {

            List<Projet> projetList = projetService.getAllProjets();
            if (projetList != null && !projetList.isEmpty()) {
                projetList.stream().forEach(projet -> {
                    List<UploadImage> imagesForRandomList = uploadImageService.getImagesByIdProjet(projet.getId());
                    if (imagesForRandomList != null && !imagesForRandomList.isEmpty()) {
                        Random random = new Random();
                        imagesList.add(imagesForRandomList.get(random.nextInt(imagesForRandomList.size())));
                    }
                });
            }
        } catch (Exception e) {

            if (e.getMessage().equals("0200") || e.getMessage().equals("0206")) {
                throw new DataNotFoundException("207", e);
            } else {
                LOG.error("Une erreur est survenue lors de la constitution du randhome", e);
                throw new DataSystemException("0310", e);
            }
        }
        return imagesList;

    }
}
