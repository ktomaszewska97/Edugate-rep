package edugate.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name = "assignfiletodepartment")
public class AssignFileToDepartment {
    @Id
    Integer idassignfiletodepartment;
    @Column
    Integer iddepartment;
    @Column
    Integer idfile;
    @Column
    Integer ispublic;

    public Integer getIdassignfiletodepartment() {
        return idassignfiletodepartment;
    }

    public Integer getIddepartment() {
        return iddepartment;
    }

    public void setIddepartment(Integer iddepartment) {
        this.iddepartment = iddepartment;
    }

    public Integer getIdfile() {
        return idfile;
    }

    public void setIdfile(Integer idfile) {
        this.idfile = idfile;
    }

    public Integer getIspublic() {
        return ispublic;
    }

    public void setIspublic(Integer ispublic) {
        this.ispublic = ispublic;
    }
}
