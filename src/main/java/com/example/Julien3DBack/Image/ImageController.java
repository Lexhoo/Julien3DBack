package com.example.Julien3DBack.Image;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/images")
public class ImageController {

    @Autowired Imageservice imageservice;
    @GetMapping()
    public List<Image> getAll(){
        return imageservice.findAll();
    }
}
