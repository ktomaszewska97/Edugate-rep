package edugate.demo.model;

import javax.persistence.*;

@Entity(name = "fieldofstudy")
public class FieldOfStudy {
    @Id
    @Column(name = "IDFieldofstudy")
    Integer IDFieldOfStudy;
    @Column(name = "IDDepartment")
    Integer IDDepartment;
    @Column(nullable = false)
    String name;
    @Column
    String about;



    public Integer getIDFieldOfStudy() {
        return IDFieldOfStudy;
    }

    public Integer getIDDepartment() {
        return IDDepartment;
    }

    public void setIDDepartment(Integer IDDepartment) {
        IDDepartment = IDDepartment;
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
