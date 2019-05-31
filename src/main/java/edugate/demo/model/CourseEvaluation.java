package edugate.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.criteria.CriteriaBuilder;

@Entity(name = "courseevaluation")
public class CourseEvaluation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer idcourseevaluation;
    @Column
    Integer iduser;
    @Column
    Integer idcourse;
    @Column
    Integer rating;
    @Column
    String description;
    
    public CourseEvaluation() {
    }
    
    public CourseEvaluation(int iduser, int idcourse, int rating) {
    	
    	this.iduser = iduser;
    	this.idcourse = idcourse;
    	this.rating = rating;
    }

    public Integer getIdcourseevaluation() {
        return idcourseevaluation;
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

    public Integer getRating() {
        return rating;
    }

    public void setRating(Integer rating) {
        this.rating = rating;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
