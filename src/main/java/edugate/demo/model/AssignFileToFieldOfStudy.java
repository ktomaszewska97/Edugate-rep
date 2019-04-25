package edugate.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.criteria.CriteriaBuilder;

@Entity(name = "assignfiletofieldofstudy")
public class AssignFileToFieldOfStudy {
    @Id
    Integer idassignfiletofieldofstudy;
    @Column
    Integer idfile;
    @Column
    Integer idfieldofstudy;
    @Column
    Integer ispublic;

    public Integer getIdassignfiletofieldofstudy() {
        return idassignfiletofieldofstudy;
    }

    public Integer getIdfile() {
        return idfile;
    }

    public void setIdfile(Integer idfile) {
        this.idfile = idfile;
    }

    public Integer getIdfieldofstudy() {
        return idfieldofstudy;
    }

    public void setIdfieldofstudy(Integer idfieldofstudy) {
        this.idfieldofstudy = idfieldofstudy;
    }

    public Integer getIspublic() {
        return ispublic;
    }

    public void setIspublic(Integer ispublic) {
        this.ispublic = ispublic;
    }
}
