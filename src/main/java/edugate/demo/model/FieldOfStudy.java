package edugate.demo.model;

import javax.persistence.*;

@Entity(name = "fieldofstudy")
public class FieldOfStudy {
    @Id
    @Column(name = "IDFieldofstudy")
    Integer iDFieldOfStudy;
    @Column(name = "IDDepartment")
    Integer IDDepartment;
    @Column(nullable = false)
    String name;
    @Column
    String about;



    public Integer getiDFieldOfStudy() {
        return iDFieldOfStudy;
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
