package com.example.springsocial.model;


import javax.persistence.*;

@Entity(name = "Privilege")
public class Privilege {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer IDAutorization;

    @Column(nullable = false)
    String name;


}
