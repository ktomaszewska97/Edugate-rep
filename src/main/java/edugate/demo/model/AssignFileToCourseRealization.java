package edugate.demo.model;

import javax.persistence.*;

@Entity(name="assignfiletocourserealization")
public class AssignFileToCourseRealization {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer idassignfiletocourserealization;
    @Column
    Integer idfile;
    @Column
    Integer idcourserealization;
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

    public Integer getIdcourserealization() {
        return idcourserealization;
    }

    public void setIdcourse(Integer idcourserealization) {
        this.idcourserealization = idcourserealization;
    }

    public Integer getIspublic() {
        return ispublic;
    }

    public void setIspublic(Integer ispublic) {
        this.ispublic = ispublic;
    }
}


