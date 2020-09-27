package com.example.Julien3DBack.UploadImage;

import com.example.Julien3DBack.exceptionHandler.DataNotFoundException;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
    public List<UploadImage> getImagesByIdProjet(Long idProjet)  {
        List<UploadImage> FilesList = this.uploadImageRepository.findByIdProjet(idProjet);
        if (FilesList.isEmpty()) {
            throw new DataNotFoundException("302");
        }
        return FilesList;
    }

    /**
     * Permet de récupérer une image grâce à son id.
     * @param id
     * @return une image.
     */
    public Optional<UploadImage> getImageById(Long id) {
        Optional<UploadImage> image = this.uploadImageRepository.findById(id);
        if (image == null) {
            throw new DataNotFoundException("301");
        }
        return image;
    }

    public void deleteImageById(Long id) {
        this.uploadImageRepository.deleteById(id);
    }

    public UploadImage createImage(UploadImage uploadImage) {
        return this.uploadImageRepository.save(uploadImage);
    }

    public void createImages(List<UploadImage> uploadImages) {
        if (uploadImages != null && !uploadImages.isEmpty()) {
            uploadImages.stream().forEach(image -> {
                this.createImage(image);
            });
        }
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
