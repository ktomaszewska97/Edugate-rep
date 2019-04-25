package edugate.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name = "Courserealization")
public class CourseRealization {
    @Id
    Integer idcourserealization;

    @Column
    Integer iduser;
    @Column
    Integer idcourse;
    @Column
    Integer groupfunction;
    @Column
    Integer year;
    @Column
    String note;
    @Column
    String about;
    @Column
    Integer coursestatus;

    public Integer getIdcourserealization() {
        return idcourserealization;
    }

    public Integer getIduser() {
        return iduser;
    }

    public void setIduser(Integer iduser) {
        this.iduser = iduser;
    }

    public Integer getIdcourse() {
        return idcourse;
    }

    public void setIdcourse(Integer idcourse) {
        this.idcourse = idcourse;
    }

    public Integer getGroupfunction() {
        return groupfunction;
    }

    public void setGroupfunction(Integer groupfunction) {
        this.groupfunction = groupfunction;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getAbout() {
        return about;
    }

    public void setAbout(String about) {
        this.about = about;
    }

    public Integer getCoursestatus() {
        return coursestatus;
    }

    public void setCoursestatus(Integer coursestatus) {
        this.coursestatus = coursestatus;
    }
}
