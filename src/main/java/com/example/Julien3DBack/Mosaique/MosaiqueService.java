package com.example.Julien3DBack.Mosaique;

import com.example.Julien3DBack.Projet.Projet;
import com.example.Julien3DBack.Projet.ProjetService;
import com.example.Julien3DBack.UploadImage.UploadImage;
import com.example.Julien3DBack.UploadImage.UploadImageService;
import com.example.Julien3DBack.exceptionHandler.DataNotFoundException;
import com.example.Julien3DBack.exceptionHandler.DataSystemException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
public class MosaiqueService {

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
            if (e.getMessage().equals("302")) {
                throw new DataNotFoundException("402", e);
            } else {
                throw new DataSystemException("un problème est survenu", e);
            }
        }
        return imagesList;

    }
}
