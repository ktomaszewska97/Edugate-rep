package com.example.springsocial.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Department {

    @Id
    private int IDDepartment;

    private int SchoolID;

    private String Name;

    private String About;

    public Department(int IDDepartment, int SchoolID, String Name, String About){

        this.IDDepartment= IDDepartment;
        this.SchoolID = SchoolID;
        this.Name = Name;
        this.About = About;
    }
}
