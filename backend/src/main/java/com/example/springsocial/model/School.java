package com.example.springsocial.model;


import javax.persistence.*;

@Entity
@Table(name = "school") //,uniqueConstraints = {
        //@UniqueConstraint(columnNames = "email")
public class School {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false)
    Integer IDSchool;
    @Column(nullable = false)
    String name;
    @Column(nullable = false)
    String description;
    @Column(nullable = false)
    String about;


    public void setAboute(String aboute) {
        this.about = aboute;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setIDSchool(Integer IDSchool) {
        this.IDSchool = IDSchool;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public Integer getIDSchool() {
        return IDSchool;
    }

    public String getAboute() {
        return about;
    }

    public String getDescription() {
        return description;
    }
}

