package edugate.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name="assigncourserealization")
public class AssignCourseRealization {
    @Id
    Integer idassigncourserealization;
    @Column
    Integer idprivilege;
    @Column
    Integer iduser;
    @Column
    Integer idcourserealization;

    public Integer getIdassigncourserealization() {
        return idassigncourserealization;
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

    public Integer getIdcourserealization() {
        return idcourserealization;
    }

    public void setIdcourserealization(Integer idcourserealization) {
        this.idcourserealization = idcourserealization;
    }
}
