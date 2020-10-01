package com.example.Julien3DBack.Categorie;


public enum CategoriesEnum {
    DIRECTION("Alex", 1l), VISUAL_EFFECT("6D", 3l);


    CategoriesEnum(String categorie, Long l) {
        this.categorie = categorie;
        this.id= id;
    }

    private String categorie;

            private Long id;

    public String getCategorie() {
        return categorie;
    }

    public void setCategorie(String categorie) {
        this.categorie = categorie;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
