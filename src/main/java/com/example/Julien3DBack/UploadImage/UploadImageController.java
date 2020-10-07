package com.example.Julien3DBack.UploadImage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.List;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/upload")
public class UploadImageController {

    @Autowired
    UploadImageService uploadImageService;

    @GetMapping()
    public List<UploadImage> getAll() {
        return uploadImageService.getAllImages();
    }

//    @GetMapping("/categorie/{categorieEnum}")
//    public List<UploadImage> getImagesByCategorie(@PathVariable CategoriesEnum categorieEnum) {
//        return this.uploadImageService.getImagesByIdCategorie(categorieEnum);
//    }
    @GetMapping("/categorie/{idCategorie}")
    public List<UploadImage> getImagesByCategorie(@PathVariable Long idCategorie) {
        return this.uploadImageService.getImagesByIdCategorie(idCategorie);
    }

    @GetMapping("/projetcategorie")
    public List<UploadImage> findByIdProjetAndIdCategorie(@PathParam("idProjet") Long idProjet, @PathParam("idCategorie")Long idCategorie){
        return this.uploadImageService.findByIdProjetAndIdCategorie(idProjet, idCategorie);
    }

    @GetMapping("/{idProjet}")
    public List<UploadImage> getImagesByProjet(@PathVariable Long idProjet) {
        return this.uploadImageService.getImagesByIdProjet(idProjet);
    }

    @PostMapping("/post")
    public UploadImage save(@RequestBody UploadImage uploadImage) {
        return this.uploadImageService.createImage(uploadImage);
    }

    @PostMapping("/post/images")
    public void saveImages(@RequestBody List<UploadImage> uploadImageList) {
        this.uploadImageService.createImages(uploadImageList);
    }

  /*  @ExceptionHandler(NotFoundException.class)
    @PutMapping("/update/{id}")
        public ResponseEntity<UploadImage> updateImage(@RequestBody UploadImage uploadImage, @PathVariable long id) throws NotFoundException {
        return new ResponseEntity<UploadImage>(this.uploadImageService.updateImage(uploadImage, id), HttpStatus.OK);
        }*/


}
