package edugate.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name = "usercourserealization")
public class UserCourseRealization {
    @Id
    Integer idusercourserealization;
    @Column
    Integer iduser;
    @Column
    Integer idcourse;
    @Column
    int isconfirm;

    public Integer getIdusercourserealization() {
        return idusercourserealization;
    }

    public Integer getIduser() {
        return iduser;
    }

    public void setIduser(Integer iduser) {
        this.iduser = iduser;
    }

    public Integer getIdcourse() {
        return idcourse;
    }

    public void setIdcourse(Integer idcourse) {
        this.idcourse = idcourse;
    }

    public int getisconfirm() {
        return isconfirm;
    }

    public void setisconfirm(int isconfirm) {
        this.isconfirm = isconfirm;
    }
}
