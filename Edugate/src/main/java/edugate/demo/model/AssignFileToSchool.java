package edugate.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.criteria.CriteriaBuilder;

@Entity(name = "assignfiletoschool")
public class AssignFileToSchool {
    @Id
    Integer idassignfiletoschool;
    @Column
    Integer idschool;
    @Column
    Integer idfile;
    @Column
    int ispublic;

    public Integer getIdassignfiletoschool() {
        return idassignfiletoschool;
    }

    public Integer getIdschool() {
        return idschool;
    }

    public void setIdschool(Integer idschool) {
        this.idschool = idschool;
    }

    public Integer getIdfile() {
        return idfile;
    }

    public void setIdfile(Integer idfile) {
        this.idfile = idfile;
    }

    public int getIspublic() {
        return ispublic;
    }

    public void setIspublic(int ispublic) {
        this.ispublic = ispublic;
    }
}
