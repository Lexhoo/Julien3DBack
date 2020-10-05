package com.example.Julien3DBack.Categorie;

import javax.persistence.*;

@Entity
public class Categorie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @Column(name = "NAME")
    private String name;

//    @JsonBackReference
//    @OneToMany(mappedBy = "categorie")
//    private Set<UploadImage> image;



//    public Set<UploadImage> getImage() {
//        return image;
//    }
//
//    public void setImage(Set<UploadImage> image) {
//        this.image = image;
//    }




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
}
