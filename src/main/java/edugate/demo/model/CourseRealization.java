package edugate.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name = "Courserealization")
public class CourseRealization {
    @Id
    Integer idcourserealization;

    @Column
    Integer idcourse;
    @Column
    Integer year;
    @Column
    String note;
    @Column
    String about;
    @Column
    Integer coursestatus;

    public int getIdcourserealization() {
        return idcourserealization;
    }

    public int getIdcourse() {
        return idcourse;
    }

    public void setIdcourse(Integer idcourse) {
        this.idcourse = idcourse;
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
