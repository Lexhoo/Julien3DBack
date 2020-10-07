package com.example.Julien3DBack.Mosaique;


import com.example.Julien3DBack.UploadImage.UploadImage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/mosaique")
public class MosaiqueController {

    @Autowired
    private MosaiqueService mosaiqueService;

    @GetMapping()
    public List<UploadImage> getMoasaique() {
        return this.mosaiqueService.getImageRandomByprojets();
    }

    @GetMapping("/categorie/{idCategorie}")
    public List<UploadImage> getImagesgorieByProjet(@PathVariable Long idCategorie) {
        return this.mosaiqueService.getImagesCategorieByProjet(idCategorie);
    }
}
