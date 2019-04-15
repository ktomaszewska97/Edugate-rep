package com.example.springsocial.model;

import javax.persistence.*;

@Entity
@Table(name ="privilege")
public class Privilege {

    @Id
    @Column(name = "IDAutorization")
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idAuthorization;
    @Column(name = "Name")
    private String name;

    public Privilege(){
    }

    public Privilege (int idAuthorization, String name){

        this.idAuthorization = idAuthorization;
        this.name = name;
    }

    public int getIdAuthorization() {
        return idAuthorization;
    }

    public String getName() {
        return name;
    }
}
