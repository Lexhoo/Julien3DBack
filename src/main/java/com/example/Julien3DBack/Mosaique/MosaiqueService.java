package com.example.Julien3DBack.Mosaique;

import com.example.Julien3DBack.Projet.Projet;
import com.example.Julien3DBack.Projet.ProjetService;
import com.example.Julien3DBack.UploadImage.UploadImage;
import com.example.Julien3DBack.UploadImage.UploadImageService;
import org.springframework.beans.factory.annotation.Autowired;
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

    public List<UploadImage> getImageRandomByprojets() {
        List<UploadImage> imagesList = new ArrayList<>();

        // TODO : gérer le fait qu'un projet n'aie pas de files.
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
        return imagesList;
    }
}
