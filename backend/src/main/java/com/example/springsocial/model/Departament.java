package com.example.springsocial.model;

import javax.persistence.*;

@Entity
@Table(name ="departament")
public class Departament {

    @Id
    @Column(name = "IDDepartament")
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
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
}
