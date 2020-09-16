package com.example.Julien3DBack.Video;

import com.example.Julien3DBack.Projet.Projet;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VideoService {

    @Autowired
    VideoRepository repository;

    public List<Video> getAllVideos() {
        return repository.findAll();
    }

    public Video create(Video video) {
        return repository.save(video);
    }

    public Video updateVideo (Video video, long id) throws NotFoundException {

        Optional<Video> studentOptional = repository.findById(id);

        if (!studentOptional.isPresent()) {
            throw new NotFoundException("Vidéo non trouvée");
        }
        video.setId(id);

        return repository.save(video);
    }

    public Optional<Video> getVideoById(Long id) {
        return repository.findById(id);
    }

    public void deleteById (Long id) {
        repository.deleteById(id);
    }

    public List<Video> getVideoByName(String name) { return repository.findByName(name);}


}
