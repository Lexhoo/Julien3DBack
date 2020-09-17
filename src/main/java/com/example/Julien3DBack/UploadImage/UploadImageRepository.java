package com.example.Julien3DBack.UploadImage;

import com.example.Julien3DBack.Projet.Projet;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UploadImageRepository extends JpaRepository<UploadImage, Long> {


//    List<UploadImage> findByCategorie(Categorie categorie);

    List<UploadImage> findByIdCategorie(Long idCategorie);

    List<UploadImage> findByProjet(Projet projet);
}
