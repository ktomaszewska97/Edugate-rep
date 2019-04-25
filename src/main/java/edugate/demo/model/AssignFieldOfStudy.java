package edugate.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name="assignfieldofstudy")
public class AssignFieldOfStudy {
    @Id
    Integer idassignfieldofstudy;
    @Column
    Integer idprivilege;
    @Column
    Integer iduser;
    @Column
    Integer idfieldofstudy;

    public Integer getIdassignfieldofstudy() {
        return idassignfieldofstudy;
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

    public Integer getIdfieldofstudy() {
        return idfieldofstudy;
    }

    public void setIdfieldofstudy(Integer idfieldofstudy) {
        this.idfieldofstudy = idfieldofstudy;
    }
}
