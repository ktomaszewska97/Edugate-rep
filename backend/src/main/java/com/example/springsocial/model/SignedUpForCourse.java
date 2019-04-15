package com.example.springsocial.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name ="signedupforcourse")
public class SignedUpForCourse {

    @Id
    @Column(name = "IDSignedUp")
    private int idSignedUp;
    @Column(name = "userID")
    private int idUser;
    @Column(name = "courseID")
    private int idCourse;

    public SignedUpForCourse(){
    }

    public SignedUpForCourse(int idSignedUp, int idUser, int idCourse){

        this.idSignedUp= idSignedUp;
        this.idUser = idUser;
    }

    public int getIdSignedUp() {
        return idSignedUp;
    }

    public int getIdUser() {
        return idUser;
    }

    public int getIdCourse() {
        return idCourse;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public void setIdCourse(int idCourse) {
        this.idCourse = idCourse;
    }
}