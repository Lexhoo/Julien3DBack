package com.example.Julien3DBack.SousCategorie;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class sousCategorie {

    @Column(name = "souscategorie", nullable= false)
    private String SousCategorie;

    public String getSousCategorie() {
        return SousCategorie;
    }

    public void setSousCategorie(String sousCategorie) {
        SousCategorie = sousCategorie;
    }
}
