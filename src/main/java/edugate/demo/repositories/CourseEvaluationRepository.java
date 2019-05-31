package edugate.demo.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import edugate.demo.model.CourseEvaluation;
import edugate.demo.model.UserCourse;

public interface CourseEvaluationRepository extends JpaRepository<CourseEvaluation,Integer> {
	
	public List<CourseEvaluation> findByIdcourse(int idcourse);
	public boolean existsByIduser(int iduser);
	public boolean existsByIduserAndIdcourse(int iduser, int idcourse);
	
}
