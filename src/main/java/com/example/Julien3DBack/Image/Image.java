package com.example.Julien3DBack.Image;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Image {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY )
    @Column(name="ID")
    private Long id;

    @Column(name="NAME")
    private String name;

    @Column(name="RESUME")
    private String resume;

    @Column(name="DATE_CREATION")
    private Date dateOfCreation;

    @Lob
    @Column(name="PROFILE_PIC")
    private byte[] profilePic;

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

    public byte[] getProfilePic() {
        return profilePic;
    }

    public void setProfilePic(byte[] profilePic) {
        this.profilePic = profilePic;
    }
}
