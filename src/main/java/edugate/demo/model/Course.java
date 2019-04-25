package edugate.demo.model;

import javax.persistence.*;

@Entity(name = "course")
public class Course {
    @Id
    Integer IDCourse;
    @Column(name = "IDFieldofstudy")
    Integer IDFieldOfStudy;
    @Column
    Integer semester;
    @Column
    Integer level;
    @Column
    String name;
    @Column
    String about;

    public Integer getIDCourse() {
        return IDCourse;
    }

    public Integer getIDFieldOfStudy() {
        return IDFieldOfStudy;
    }

    public void setIDFieldOfStudy(Integer IDFieldOfStudy) {
        this.IDFieldOfStudy = IDFieldOfStudy;
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
