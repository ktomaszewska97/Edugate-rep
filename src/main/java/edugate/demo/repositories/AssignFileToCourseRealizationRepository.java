package edugate.demo.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import edugate.demo.model.AssignFileToCourseRealization;
import edugate.demo.model.Comment;

public interface AssignFileToCourseRealizationRepository extends JpaRepository<AssignFileToCourseRealization,Integer> {
	
	public List<AssignFileToCourseRealization> findByIdcourserealization(int idCourseRealization);
}
