package com.example.Julien3DBack.Video;

import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin
@RequestMapping("/videos")
public class VideoController {

    @Autowired VideoService videoService;

    @Autowired VideoRepository repository;

    @GetMapping()
    public List<Video> getAllVideos(){
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Video> getVideoDataByID(@PathVariable("id") long video_id) {
        Optional<Video> videoData = repository.findById(video_id);

        if (videoData.isPresent()) {
            return new ResponseEntity<>(videoData.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/post")
    public Video save(@RequestBody Video video) {
        return videoService.create(video);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Video> updateVideo(@RequestBody Video video, @PathVariable long id) throws NotFoundException{
        return new ResponseEntity<Video>(this.videoService.updateVideo(video, id), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteVideo(@PathVariable("id") long id, Model model) {
        Video video = repository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid Projet Id:" + id));
        repository.delete(video);
        model.addAttribute("video", repository.findAll());
        return "index";
    }

}
