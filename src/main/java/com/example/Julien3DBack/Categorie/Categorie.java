package com.example.Julien3DBack.Categorie;

import com.example.Julien3DBack.DatasFiles.DatasFiles;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Categorie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @Column(name = "NAME")
    private String name;

    @OneToMany(mappedBy = "categorie")
    private Set<DatasFiles> datasFiles;


    public Set<DatasFiles> getDatasFiles() {
        return datasFiles;
    }

    public void setDatasFiles(Set<DatasFiles> datasFiles) {
        this.datasFiles = datasFiles;
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
