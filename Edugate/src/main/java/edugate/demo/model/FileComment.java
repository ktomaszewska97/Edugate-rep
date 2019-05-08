package edugate.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name="filecomment")
public class FileComment {
    @Id
    Integer idfilecomment;
    @Column
    Integer iduser;
    @Column
    Integer idfile;
    @Column
    String message;
    @Column
    Integer isvisible;

    public Integer getIdfilecomment() {
        return idfilecomment;
    }

    public Integer getIduser() {
        return iduser;
    }

    public void setIduser(Integer iduser) {
        this.iduser = iduser;
    }

    public Integer getIdfile() {
        return idfile;
    }

    public void setIdfile(Integer idfile) {
        this.idfile = idfile;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Integer getIsvisible() {
        return isvisible;
    }

    public void setIsvisible(Integer isvisible) {
        this.isvisible = isvisible;
    }
}
