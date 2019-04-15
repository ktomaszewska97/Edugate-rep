package com.example.springsocial.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name ="usercourserealization")
public class UserCourseRealization {

    @Id
    @Column(name = "IDUserCourseRealization")
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idUserCourseRealization;
    @Column(name = "UserIDUser")
    private int userIDUser;
    @Column(name = "CourseRealizationIDCourse")
    private int courseRealizationIDCourse;
    @Column(name = "IsConfirm")
    private int isConfirm;

    public UserCourseRealization(){
    }

    public UserCourseRealization(int idUserCourseRealization, int userIDUser, int courseRealizationIDCourse,
                                 int isConfirm){

        this.idUserCourseRealization = idUserCourseRealization;
        this.userIDUser = userIDUser;
        this.courseRealizationIDCourse = courseRealizationIDCourse;
        this.isConfirm = isConfirm;
    }

    public int getIdUserCourseRealization() {
        return idUserCourseRealization;
    }

    public int getUserIDUser() {
        return userIDUser;
    }

    public int getCourseRealizationIDCourse() {
        return courseRealizationIDCourse;
    }

    public int getIsConfirm() {
        return isConfirm;
    }
}
