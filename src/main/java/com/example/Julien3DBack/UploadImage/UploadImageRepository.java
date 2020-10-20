package com.example.Julien3DBack.UploadImage;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UploadImageRepository extends JpaRepository<UploadImage, Long> {


//    List<UploadImage> findByCategorie(Categorie categorie);

    List<UploadImage> findByIdCategorie(Long idCategorie);

    List<UploadImage> findByIdProjet(Long idProjet);

    List<UploadImage> findByIdProjetAndIdCategorie(Long idProjet, Long idCategorie);

    List<UploadImage> findByHasVideo(boolean video);
}
