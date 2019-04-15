package com.example.springsocial.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name ="courserealization")
public class CourseRealization {

    @Id
    @Column(name = "IDCourseRealization")
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idCourseRealization;
    @Column(name = "UserID")
    private int userID;
    @Column(name = "CourseID")
    private int courseID;
    @Column(name = "FunkcjaWGrupie")
    private int funkcjaWGrupie;
    @Column(name = "Year")
    private int year;
    @Column(name = "Note")
    private String note;
    @Column(name = "About")
    private String about;
    @Column(name = "CourseStatus")
    private int courseStatus;

    public CourseRealization(){
    }

    public CourseRealization(int idCourseRealization, int userID, int funkcjaWGrupie, int year, String note,
                             String about, int courseStatus){

        this.idCourseRealization = idCourseRealization;
        this.userID = userID;
        this.funkcjaWGrupie = funkcjaWGrupie;
        this.year = year;
        this.note = note;
        this.about = about;
        this.courseStatus = courseStatus;
    }

    public int getIdCourseRealization() {
        return idCourseRealization;
    }

    public int getUserID() {
        return userID;
    }

    public int getCourseID() {
        return courseID;
    }

    public int getYear() {
        return year;
    }

    public String getNote() {
        return note;
    }

    public String getAbout() {
        return about;
    }

    public int getCourseStatus() {
        return courseStatus;
    }
}
