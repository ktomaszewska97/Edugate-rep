package edugate.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name ="comment")
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer idcomment;
    @Column
    Integer iduser;
    @Column
    Integer idcourserealization;
    @Column
    String message;
    @Column
    Integer isvisible;
    
    public Comment(int iduser, int idcourserealization, String message) {
    	this.iduser = iduser;
    	this.idcourserealization = idcourserealization;
    	this.message = message;
    }
    
    public Comment() {}

    public Integer getIdcomment() {
        return idcomment;
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
