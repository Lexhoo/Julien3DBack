package com.example.Julien3DBack.UploadImage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
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
//        return this.uploadImageService.getImagesByCategorie(categorieEnum);
//    }
    @GetMapping("/categorie/{idCategorie}")
    public List<UploadImage> getImagesByCategorie(@PathVariable Long idCategorie) {
        return this.uploadImageService.getImagesByIdCategorie(idCategorie);
    }

    @GetMapping("/projet/{idProjet}")
    public List<UploadImage> getImagesByProjet(@PathVariable Long idProjet) {
        return this.uploadImageService.getImagesByIdProjet(idProjet);
    }

    @PostMapping("/post")
    public UploadImage save(@RequestBody UploadImage uploadImage) {
        return this.uploadImageService.createImage(uploadImage);
    }

  /*  @ExceptionHandler(NotFoundException.class)
    @PutMapping("/update/{id}")
        public ResponseEntity<UploadImage> updateImage(@RequestBody UploadImage uploadImage, @PathVariable long id) throws NotFoundException {
        return new ResponseEntity<UploadImage>(this.uploadImageService.updateImage(uploadImage, id), HttpStatus.OK);
        }*/

}
