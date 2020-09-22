package com.example.Julien3DBack.UploadImage;

import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UploadImageService {

    @Autowired UploadImageRepository uploadImageRepository;

    public List<UploadImage> getAllImages(){
        return uploadImageRepository.findAll();
    }

//    public List<UploadImage> getImagesByCategorie(CategoriesEnum categorie) {
//        Categorie categorie1 = new Categorie();
//        categorie1.setId(categorie.getId());
//        categorie1.setName(categorie.getCategorie());
//        return this.uploadImageRepository.findByCategorie(categorie1);
//    }

    /**
     * Permet de récupérer toutes les images liées à la catégorie.
     * @param idCategorie
     * @return une liste d'images
     */
    public List<UploadImage> getImagesByIdCategorie(Long idCategorie) {
        return this.uploadImageRepository.findByIdCategorie(idCategorie);
    }

    /**
     * Permet de récupérer toutes les images liées à un projet.
     * @param idProjet
     * @return une liste d'images.
     */
    public List<UploadImage> getImagesByIdProjet(Long idProjet) {
        return this.uploadImageRepository.findByIdProjet(idProjet);
    }

    /**
     * Permet de récupérer une image grâce à son id.
     * @param id
     * @return une image.
     */
    public Optional<UploadImage> getImageById(Long id) {
        return this.uploadImageRepository.findById(id);
    }

    public void deleteImageById(Long id) {
        this.uploadImageRepository.deleteById(id);
    }

    public UploadImage createImage(UploadImage uploadImage) {
        return this.uploadImageRepository.save(uploadImage);
    }
    
    public UploadImage updateImage(Long id, UploadImage uploadImage) throws NotFoundException {
        Optional<UploadImage> studentOptional = uploadImageRepository.findById(id);

        if (!studentOptional.isPresent()) {
            throw new NotFoundException("Fichier non trouvé");
        }
        uploadImage.setId(id);

        return this.uploadImageRepository.save(uploadImage);
    }



}
