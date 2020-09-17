package com.example.Julien3DBack.Categorie;


public enum CategoriesEnum {
    ALEX("Alex", 1l), SIXD("6D", 3l);


    CategoriesEnum(String categorie, Long l) {
        this.categorie = categorie;
        this.id= id;
    }

    private String categorie;

            private Long id;

    public String getCategorie() {
        return categorie;
    }

    public Long getId() {
        return id;
    }
}
