package com.example.Julien3DBack.Image;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Imageservice {


    @Autowired ImageRepository repository;

    public List<Image> findAll() {
        return repository.findAll();
    }
}
