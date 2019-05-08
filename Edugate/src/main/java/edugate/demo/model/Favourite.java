package edugate.demo.model;


import javax.persistence.*;

@Entity(name = "favourite")
public class Favourite {
    @Id
    @Column(name = "IDFavourite")
    Integer idFavourite;
    @Column
    Integer IDUser;
    @Column(nullable = false)
    String url;
    @Column(nullable = false)
    String name;

    public Integer getIDUser() {
        return IDUser;
    }

    public void setIDUser(Integer IDUser) {
        IDUser = IDUser;
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

    public String getname() {
        return name;
    }

    public void setname(String name) {
        this.name = name;
    }
}
