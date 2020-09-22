package com.example.Julien3DBack.Mosaique;


import com.example.Julien3DBack.UploadImage.UploadImage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
