package com.example.Julien3DBack.Image;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Service
public class ImageService {


    @Autowired ImageRepository repository;

    public List<Image> findAll() {
        return repository.findAll();
    }

    public Image create(Image image) {
        return repository.save(image);
    }

    public Image updateImage(Image image) {
        return repository.save(image);
    }

    public Image storeFile(MultipartFile file) {
        // Normalize file name
        String fileName = StringUtils.cleanPath(file.getOriginalFilename());

        try {
            // Check if the file's name contains invalid characters
            if(fileName.contains("..")) {
                throw new FileStorageException("Sorry! Filename contains invalid path sequence " + fileName);
            }

            Image image = new Image(fileName, file.getContentType(), file.getBytes());

            return repository.save(image);
        } catch (IOException ex) {
            throw new FileStorageException("Could not store file " + fileName + ". Please try again!", ex);
        }
    }

    public Image getFile(Long fileId) {
        return repository.findById(fileId)
                .orElseThrow(() -> new MyFileNotFoundException("File not found with id " + fileId));
    }
}
