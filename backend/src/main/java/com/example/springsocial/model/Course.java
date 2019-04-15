package com.example.springsocial.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name ="course")
public class Course {

    @Id
    @Column(name = "IDCourse")
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idCourse;
    @Column(name = "FieldOfStudyID")
    private int fieldOfStudyID;
    @Column(name = "Semester")
    private int semester;
    @Column(name = "Level")
    private int level;
    @Column(name = "Name")
    private String name;

    public Course() {
    }

    public Course(int idCourse, int fieldOfStudyID, int semester, int level, String name) {

        this.idCourse = idCourse;
        this.fieldOfStudyID = fieldOfStudyID;
        this.semester = semester;
        this.level = level;
        this.name = name;
    }

    public int getIdCourse() {
        return idCourse;
    }

    public int getFieldOfStudyID() {
        return fieldOfStudyID;
    }

    public int getSemester() {
        return semester;
    }

    public int getLevel() {
        return level;
    }

    public String getName() {
        return name;
    }
}