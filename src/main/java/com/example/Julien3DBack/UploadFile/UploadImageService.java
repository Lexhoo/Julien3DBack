package com.example.Julien3DBack.UploadFile;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UploadImageService {

    @Autowired UploadImageRepository uploadImageRepository;

    public List<UploadImage> getAllImages(){
        return uploadImageRepository.findAll();
    }


}
