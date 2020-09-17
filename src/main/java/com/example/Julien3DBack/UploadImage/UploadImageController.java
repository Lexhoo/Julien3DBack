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

    @PostMapping("/post")
    public UploadImage save(@RequestBody UploadImage uploadImage) {
        return uploadImageService.createImage(uploadImage);
    }
}
