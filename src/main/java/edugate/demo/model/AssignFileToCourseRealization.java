package edugate.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name="assignfiletocourserealization")
public class AssignFileToCourseRealization {
    @Id
    Integer idassignfiletocourserealization;
    @Column
    Integer idfile;
    @Column
    Integer idcourse;
    @Column
    Integer ispublic;

    public Integer getIdassignfiletocourserealization() {
        return idassignfiletocourserealization;
    }

    public Integer getIdfile() {
        return idfile;
    }

    public void setIdfile(Integer idfile) {
        this.idfile = idfile;
    }

    public Integer getIdcourse() {
        return idcourse;
    }

    public void setIdcourse(Integer idcourse) {
        this.idcourse = idcourse;
    }

    public Integer getIspublic() {
        return ispublic;
    }

    public void setIspublic(Integer ispublic) {
        this.ispublic = ispublic;
    }
}


