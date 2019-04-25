package edugate.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name= "assigndepartment")
public class AssignDepartment {
    @Id
    Integer idassigndepartment;
    @Column
    Integer idprivilege;
    @Column
    Integer iduser;
    @Column
    Integer iddepartment;

    public Integer getIdassigndepartment() {
        return idassigndepartment;
    }

    public Integer getIdprivilege() {
        return idprivilege;
    }

    public void setIdprivilege(Integer idprivilege) {
        this.idprivilege = idprivilege;
    }

    public Integer getIduser() {
        return iduser;
    }

    public void setIduser(Integer iduser) {
        this.iduser = iduser;
    }

    public Integer getIddepartment() {
        return iddepartment;
    }

    public void setIddepartment(Integer iddepartment) {
        this.iddepartment = iddepartment;
    }
}
