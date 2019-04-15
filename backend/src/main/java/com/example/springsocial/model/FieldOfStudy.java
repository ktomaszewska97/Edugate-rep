package com.example.springsocial.model;

import javax.persistence.*;

@Entity(name = "fieldofstudy")
public class FieldOfStudy {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer idFieldOfStudy;
    @ManyToOne
    Departament departamentId;
    @Column(nullable = false)
    String name;
    @Column
    String about;



    public Integer getIdFieldOfStudy() {
        return idFieldOfStudy;
    }

    public Departament getDepartamentId() {
        return departamentId;
    }

    public void setDepartamentId(Departament departamentId) {
        this.departamentId = departamentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAbout() {
        return about;
    }

    public void setAbout(String about) {
        this.about = about;
    }
}
