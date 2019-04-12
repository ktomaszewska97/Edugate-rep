package com.example.springsocial.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name ="departament")
public class Departament {

    @Id
    @Column(name = "IDDepartament")
    private int idDepartament;
    @Column(name = "SchoolID")
    private int schoolID;
    @Column(name = "Name")
    private String name;
    @Column(name = "Aboute")
    private String about;

    public Departament(){
    }

    public Departament(int idDepartament, int schoolID, String name, String about){

        this.idDepartament= idDepartament;
        this.schoolID = schoolID;
        this.name = name;
        this.about = about;
    }

    public int getIdDepartament() {
        return idDepartament;
    }

    public int getSchoolID() {
        return schoolID;
    }

    public String getName() {
        return name;
    }

    public String getAbout() {
        return about;
    }

    public void setName(String setName) {
        name = setName;
    }

    public void setAbout(String setAbout) {
        about = setAbout;
    }
}
