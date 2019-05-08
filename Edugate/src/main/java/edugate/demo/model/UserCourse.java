package edugate.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name = "usercourse")
public class UserCourse {
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer idusercourse;
    @Column
    Integer iduser;
    @Column
    Integer idcourserealization;
    
    public UserCourse() {
    }

    public UserCourse(int IDUser, int IDCourseRealization) {
    	
    	this.iduser = IDUser;
    	this.idcourserealization = IDCourseRealization;
	}

	public Integer getIdusercourse() {
        return idusercourse;
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

    public void setIdcourse(Integer idcourserealization) {
        this.idcourserealization = idcourserealization;
    }
}
