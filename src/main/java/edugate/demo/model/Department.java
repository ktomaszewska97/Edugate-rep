package edugate.demo.model;

import javax.persistence.*;

@Entity(name = "department")
public class Department {
    @Id
    @Column(name = "IDDepartment")
    Integer iDDepartament;
    @Column(name="iDSchool")
    Integer IDSchool;
    @Column
    String name;

    @Column
    String about;

    public Integer getiDDepartament() {
        return iDDepartament;
    }

    public Integer getIDSchool() {
        return IDSchool;
    }

    public void setIDSchool(Integer IDSchool) {
        this.IDSchool = IDSchool;
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
