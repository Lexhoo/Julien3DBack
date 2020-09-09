package com.example.Julien3DBack.Video;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/video")
public class VideoController {

    @Autowired VideoRepository videoRepository;
    @GetMapping()
    public List<Video> getAll(){
        return videoRepository.findAll();
    }

}
