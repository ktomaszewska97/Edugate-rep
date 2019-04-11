package com.example.springsocial.model;


import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "users")
        //@UniqueConstraint(columnNames = "IDUser")
public class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer IDUser;

    @ManyToOne
    School SchoolID;

    @Column(nullable = false)
    String login;

    @Column(nullable = false)
    String password;

    @Column(nullable = false)
    String email;

    @Column
    Date dateRegistered;

    @Column
    Integer accountStatus;

    @Column
    Integer accountType;

    @Column
    Double overallRating;

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getDateRegistered() {
        return dateRegistered;
    }

    public void setDateRegistered(Date dateRegistered) {
        this.dateRegistered = dateRegistered;
    }

    public Integer getAccountStatus() {
        return accountStatus;
    }

    public void setAccountStatus(Integer accountStatus) {
        this.accountStatus = accountStatus;
    }

    public Integer getAccountType() {
        return accountType;
    }

    public void setAccountType(Integer accountType) {
        this.accountType = accountType;
    }

    public Double getOverallRating() {
        return overallRating;
    }

    public void setOverallRating(Double overallRating) {
        this.overallRating = overallRating;
    }

    public Integer getIDUser() {
        return IDUser;
    }

    public void setIDUser(Integer IDUser) {
        this.IDUser = IDUser;
    }

    public School getSchoolID() {
        return SchoolID;
    }

    public void setSchoolID(School schoolID) {
        SchoolID = schoolID;
    }
}
