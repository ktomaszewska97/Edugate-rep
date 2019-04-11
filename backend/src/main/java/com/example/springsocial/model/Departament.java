package com.example.springsocial.model;

import javax.persistence.*;

@Entity(name = "departament")
public class Departament {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer idDepartament;
    @ManyToOne
    School schoolId;
    @Column
    String name;

    public Integer getIdDepartament() {
        return idDepartament;
    }

    public School getSchoolId() {
        return schoolId;
    }

    public void setSchoolId(School schoolId) {
        this.schoolId = schoolId;
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

    @Column
    String about;


}
