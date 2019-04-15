package com.example.springsocial.model;

import javax.persistence.*;

@Entity
@Table(name ="fieldofstudy")
public class FieldOfStudy {

    @Id
    @Column(name = "IDFieldOfStudy")
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idFieldOfStudy;
    @Column(name = "DepartamentID")
    private int departamentID;
    @Column(name = "Name")
    private String name;
    @Column(name = "Aboute")
    private String about;

    public FieldOfStudy(){
    }

    public FieldOfStudy(int idFieldOfStudy, int departamentID, String name, String about){

        this.idFieldOfStudy = idFieldOfStudy;
        this.departamentID = departamentID;
        this.name = name;
        this.about = about;
    }

    public int getIdFieldOfStudy() {
        return idFieldOfStudy;
    }

    public int getDepartamentID() {
        return departamentID;
    }

    public String getName() {
        return name;
    }

    public String getAbout() {
        return about;
    }
}
