package com.example.springsocial.model;

import javax.persistence.*;

@Entity(name = "course")
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer courseID;
    @ManyToOne
    FieldOfStudy fieldofStudyID;
    @Column
    Integer semester;
    @Column
    Integer level;
    @Column
    String name;
    @Column
    String about;

    public Integer getCourseID() {
        return courseID;
    }

    public FieldOfStudy getFieldofStudyID() {
        return fieldofStudyID;
    }

    public void setFieldofStudyID(FieldOfStudy fieldofStudyID) {
        this.fieldofStudyID = fieldofStudyID;
    }

    public Integer getSemester() {
        return semester;
    }

    public void setSemester(Integer semester) {
        this.semester = semester;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAbout() {
        return about;
    }

    public void setAbout(String about) {
        this.about = about;
    }
}
