package com.example.Julien3DBack.UploadFile;

import com.example.Julien3DBack.Categorie.Categorie;
import com.example.Julien3DBack.Projet.Projet;
import com.example.Julien3DBack.Video.Video;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.*;
import java.util.Date;

@Entity
public class UploadImage {

    public UploadImage() {
        super();
    }

    public UploadImage(String name, String type, byte[] picByte) {
        this.name = name;
        this.type = type;
        this.picByte = picByte;
    }

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "type")
    private String type;

    @Column(name="RESUME")
    private String resume;

    @JsonFormat(pattern="dd-MM-yyyy")
    @Column(name="DATE_CREATION")
    private Date dateOfCreation;

    @ManyToOne
    @JoinColumn(name = "categorie_id", nullable= false)
    private Categorie categorie;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "video_id", referencedColumnName = "id")
    private Video video;

    @ManyToOne
    @JoinColumn(name = "projet_id", nullable = false)
    private Projet projet;

    public Long getId() {
        return id;
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

    public Categorie getCategorie() {
        return categorie;
    }

    public void setCategorie(Categorie categorie) {
        this.categorie = categorie;
    }

    public Video getVideo() {
        return video;
    }

    public void setVideo(Video video) {
        this.video = video;
    }

    public Projet getProjet() {
        return projet;
    }

    public void setProjet(Projet projet) {
        this.projet = projet;
    }

    public void setId(Long id) {
        this.id = id;
    }

    //image bytes can have large lengths so we specify a value
    //which is more than the default length for picByte column
    @Lob
    @Column(name = "picByte", length = 100000)
    private byte[] picByte;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public byte[] getPicByte() {
        return picByte;
    }

    public void setPicByte(byte[] picByte) {
        this.picByte = picByte;
    }
}
