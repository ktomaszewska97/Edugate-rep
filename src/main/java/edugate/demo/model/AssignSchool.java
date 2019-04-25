package edugate.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name="assignschool")
public class AssignSchool {
    @Id
    Integer idassignschool;
    @Column
    Integer idprivilege;
    @Column
    Integer iduser;

    public Integer getIdassignschool() {
        return idassignschool;
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

    public Integer getIdschool() {
        return idschool;
    }

    public void setIdschool(Integer idschool) {
        this.idschool = idschool;
    }

    @Column
    Integer idschool;
}
