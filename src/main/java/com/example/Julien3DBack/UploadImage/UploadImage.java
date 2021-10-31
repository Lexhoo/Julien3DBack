package com.example.Julien3DBack.UploadImage;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.util.Date;

@Entity
public class UploadImage {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "titre")
    private String titre;

    @Column(name = "title")
    private String title;

    @Column(name="resume")
    private String resume;

    @Column(name="english_resume")
    private String englishResume;

    @JsonFormat(pattern="dd-MM-yyyy")
    @Column(name="DATE_CREATION")
    private Date dateCreation;

    @Column(name="has_video", nullable = false)
    private boolean hasVideo;

    @Column(name="video_url")
    private String videoUrl;

    @Column(name="image_url", nullable = false)
    private String imageUrl;

    @Column(name = "souscategorie_id", nullable= false)
    private Long idSousCategorie;

    @Column(name = "categorie_id", nullable= false)
    private Long idCategorie;
    @Column(name = "projet_name")
    private String projetName;

    @Column(name = "projet_id", nullable = false)
    private Long idProjet;
    
    @Column(name="is_image_vitrine")
    private boolean isImageVitrine;

    public String getProjetName() {
        return projetName;
    }

    public void setProjetName(String projetName) {
        this.projetName = projetName;
    }

    public Long getIdSousCategorie() {
        return idSousCategorie;
    }

    public void setIdSousCategorie(Long idSousCategorie) {
        this.idSousCategorie = idSousCategorie;
    }

    public Long getId() {
        return id;
    }

    public Long getIdCategorie() {
        return idCategorie;
    }

    public void setIdCategorie(Long idCategorie) {
        this.idCategorie = idCategorie;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getEnglishResume() {
        return englishResume;
    }

    public void setEnglishResume(String englishResume) {
        this.englishResume = englishResume;
    }

    public String getResume() {
        return resume;
    }

    public void setResume(String resume) {
        this.resume = resume;
    }

    public Date getDateCreation() {
        return dateCreation;
    }

    public void setDateCreation(Date dateCreation) {
        this.dateCreation = dateCreation;
    }

    public boolean isHasVideo() {
        return hasVideo;
    }

    public void setHasVideo(boolean hasVideo) {
        this.hasVideo = hasVideo;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getVideoUrl() {
        return videoUrl;
    }

    public void setVideoUrl(String videoUrl) {
        this.videoUrl = videoUrl;
    }

    public Long getIdProjet() {
        return idProjet;
    }

    public void setIdProjet(Long idProjet) {
        this.idProjet = idProjet;
    }

	public boolean isImageVitrine() {
		return isImageVitrine;
	}

	public void setImageVitrine(boolean isImageVitrine) {
		this.isImageVitrine = isImageVitrine;
	}


}
