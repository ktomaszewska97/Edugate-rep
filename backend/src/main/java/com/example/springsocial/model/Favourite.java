package com.example.springsocial.model;


import javax.persistence.*;

@Entity(name = "favourite")
public class Favourite {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer idFavourite;
    @ManyToOne
    Users UserID;
    @Column(nullable = false)
    String url;
    @Column(nullable = false)
    String nazwa;

    public Users getUserID() {
        return UserID;
    }

    public void setUserID(Users userID) {
        UserID = userID;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Integer getIdFavourite() {
        return idFavourite;
    }

    public String getNazwa() {
        return nazwa;
    }

    public void setNazwa(String nazwa) {
        this.nazwa = nazwa;
    }
}
