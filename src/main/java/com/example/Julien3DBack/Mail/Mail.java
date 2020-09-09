package com.example.Julien3DBack.Mail;

import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Mail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY )
    @Column(name="ID")
    private Long id;

    @Column(name="MAIL")
    private String mail;

    @Column(name = "DATEHEURE")
    private Date dateheure;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public Date getDateheure() {
        return dateheure;
    }

    public void setDateheure(Date dateheure) {
        this.dateheure = dateheure;
    }
}
