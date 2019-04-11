package com.example.springsocial.model;

import javax.persistence.*;

@Entity
@Table(name ="school")
public class School {

    @Id
    @Column(name = "IDSchool")
    private int IDSchool;
    @Column(name = "Name")
    private String Name;
    @Column(name = "Description")
    private String Description;
    @Column(name = "about")
    private String About;

    public School(){
    }

    public School(int IDSchool, String Name, String Description, String About){

        this.IDSchool = IDSchool;
        this.Name = Name;
        this.Description = Description;
        this.About = About;
    }

    public int getIDSchool() {
        return IDSchool;
    }

    public String getName() {
        return Name;
    }

    public String getAbout() {
        return About;
    }

    public String getDescription() {
        return Description;
    }
}
