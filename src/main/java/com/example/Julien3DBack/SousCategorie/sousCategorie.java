package com.example.Julien3DBack.SousCategorie;

import javax.persistence.*;

@Entity
public class sousCategorie {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Column(name = "nomSousCategorie", nullable= false)
    private String nomSousCategorie;

    public String getSousCategorie() {
        return nomSousCategorie;
    }

    public void setSousCategorie(String sousCategorie) {
        this.nomSousCategorie = nomSousCategorie;
    }
}
