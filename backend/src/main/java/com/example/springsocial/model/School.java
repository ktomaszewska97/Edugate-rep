package com.example.springsocial.model;

import javax.persistence.*;

@Entity
@Table(name ="school")
public class School {

    @Id
    @Column(name = "IDSchool")
    private int idSchool;
    @Column(name = "Name")
    private String name;
    @Column(name = "Description")
    private String description;
    @Column(name = "About")
    private String about;

    public School(){
    }

    public School(int idSchool, String name, String description, String about){

        this.idSchool = idSchool;
        this.name = name;
        this.description = description;
        this.about = about;
    }

    public int getIDSchool() {
        return idSchool;
    }

    public String getName() {
        return name;
    }

    public String getAbout() {
        return about;
    }

    public String getDescription() {
        return description;
    }
}
