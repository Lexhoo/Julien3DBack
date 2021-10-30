package com.example.Julien3DBack.UploadImage;

import com.example.Julien3DBack.exceptionHandler.DataNotFoundException;
import com.example.Julien3DBack.exceptionHandler.DataSystemException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UploadImageService {

    private static final Logger LOG = LogManager.getLogger(UploadImageService.class);

    @Autowired UploadImageRepository uploadImageRepository;

    public List<UploadImage> getAllImages(){
        return uploadImageRepository.findAll();
    }

    /**
     * Permet de récupérer toutes les images liées à la catégorie.
     * @param idCategorie
     * @return une liste d'images
     */
    public List<UploadImage> getImagesByIdCategorie(Long idCategorie) {
        return this.uploadImageRepository.findByIdCategorie(idCategorie);
    }

    public List<UploadImage> findByIdProjetAndIdCategorie(Long idProjet, Long idCategorie) {
        return this.uploadImageRepository.findByIdProjetAndIdCategorie(idProjet, idCategorie);
    }
    /**
     * Permet de récupérer toutes les images liées à un projet.
     * @param idProjet
     * @return une liste d'images.
     */
    public List<UploadImage> getImagesByIdProjet(Long idProjet)  {
        List<UploadImage> FilesList = this.uploadImageRepository.findByIdProjet(idProjet);

        return FilesList;
    }

    /**
     * Permet de récupérer une image grâce à son id.
     * @param id
     * @return une image.
     */
    public UploadImage getImageById(Long id) {
        Optional<UploadImage> image;
        try {
            image = this.uploadImageRepository.findById(id);
            if (!image.isPresent()) {
                throw new DataNotFoundException("0210");
            }
        } catch (Exception e) {
            if ("0210".equals(e.getMessage())) {
                throw new DataNotFoundException("0210", e);
            } else {
                LOG.error("Une erreur est survenue lors de l'appel BDD getImageById", e);
                throw new DataSystemException("0311", e);
            }

        }
        return image.get();
    }

    public UploadImage createImage(UploadImage uploadImage) {
        return this.uploadImageRepository.save(uploadImage);
    }

    public void createImages(List<UploadImage> uploadImageList) {
        if (uploadImageList != null && !uploadImageList.isEmpty()) {
            uploadImageList.stream().forEach(image -> {
                this.createImage(image);
            });
        }
    }

    public void deleteImageById(Long id) {
        this.uploadImageRepository.deleteById(id);
    }

    public List<UploadImage> hasvideo() {
        return this.uploadImageRepository.findByHasVideo(true);
    }
    
    public List<UploadImage> getImagesVitrine() {
    	return this.uploadImageRepository.findByIsImageVitrine(true);
    }

//    public UploadImage updateImage(Long id, UploadImage uploadImage) {
//        Optional<UploadImage> studentOptional = uploadImageRepository.findById(id);
//
//        if (!studentOptional.isPresent()) {
//            throw new DataNotFoundException("Fichier non trouvé");
//        }
//        uploadImage.setId(id);
//
//        return this.uploadImageRepository.save(uploadImage);
//    }

}
