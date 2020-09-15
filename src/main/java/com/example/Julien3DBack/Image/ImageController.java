package com.example.Julien3DBack.Image;

import com.example.Julien3DBack.Projet.Projet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@CrossOrigin
@RequestMapping("/images")
public class ImageController {

    @Autowired ImageService imageService;

    @Autowired ImageRepository repository;

    @GetMapping()
    public List<Image> getAll() {
        return imageService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Image> getImageDataByID(@PathVariable("id") long image_id) {
        Optional<Image> imageData = repository.findById(image_id);

        if (imageData.isPresent()) {
            return new ResponseEntity<>(imageData.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/post")
    public Image save(@RequestBody Image image) {
        return imageService.create(image);
    }

    @PutMapping("/update/{id}")
    public Image image(@RequestBody Image image) {
        return imageService.updateImage(image);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteImage(@PathVariable("id") long id, Model model) {
        Image image = repository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid Image Id:" + id));
        repository.delete(image);
        model.addAttribute("projet", repository.findAll());
        return "index";
    }

    @PostMapping("/uploadFile")
    public UploadFileResponse uploadFile(@RequestParam("file") MultipartFile file) {
        Image image = imageService.storeFile(file);

        String fileDownloadUri = ServletUriComponentsBuilder.fromCurrentContextPath()
                .path("/downloadFile/")
                .path(image.getId().toString())
                .toUriString();

        return new UploadFileResponse(image.getFileName(), fileDownloadUri,
                file.getContentType(), file.getSize());
    }

    @PostMapping("/uploadMultipleFiles")
    public List<UploadFileResponse> uploadMultipleFiles(@RequestParam("files") MultipartFile[] files) {
        return Arrays.asList(files)
                .stream()
                .map(file -> uploadFile(file))
                .collect(Collectors.toList());
    }

    @GetMapping("/downloadFile/{fileId}")
    public ResponseEntity<Resource> downloadFile(@PathVariable Long fileId) {
        // Load file from database
        Image image = imageService.getFile(fileId);

        return ResponseEntity.ok()
                .contentType(MediaType.parseMediaType(image.getFileType()))
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + image.getFileName() + "\"")
                .body(new ByteArrayResource(image.getData()));
    }
}
