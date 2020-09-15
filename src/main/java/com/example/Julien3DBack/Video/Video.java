package com.example.Julien3DBack.Video;

import com.example.Julien3DBack.Image.Image;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Video {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY )
    @Column(name="ID")
    private Long id;

    @Column(name="NAME")
    private String name;

    @Column(name="VIDEO_URL")
    private String videoUrl;

    @OneToOne(mappedBy = "video")
    private Image image;

       @Column(name="RESUME")
    private String resume;

    @Column(name="DATE_CREATION")
    private Date dateOfCreation;

    public Image getImage() {
        return image;
    }

    public String getVideoUrl() {
        return videoUrl;
    }

    public void setVideoUrl(String videoUrl) {
        this.videoUrl = videoUrl;
    }

    public void setImage(Image image) {
        this.image = image;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getResume() {
        return resume;
    }

    public void setResume(String resume) {
        this.resume = resume;
    }

    public Date getDateOfCreation() {
        return dateOfCreation;
    }

    public void setDateOfCreation(Date dateOfCreation) {
        this.dateOfCreation = dateOfCreation;
    }
}
