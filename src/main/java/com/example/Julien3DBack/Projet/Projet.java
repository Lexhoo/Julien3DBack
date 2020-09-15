package com.example.Julien3DBack.Projet;


import com.example.Julien3DBack.Image.Image;
import org.springframework.web.bind.annotation.PathVariable;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Projet {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="ID")
    private Long id;

    @Column(name = "name")
    private String name;

    @OneToMany(mappedBy = "projet")
    private Set<Image> images;

    public Set<Image> getImages() {
        return images;
    }

    public void setImages(Set<Image> images) {
        this.images = images;
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
}
