package edugate.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import edugate.demo.model.AssignCourseRealization;

import java.util.List;

public interface AssignCourseRealizationRepository extends JpaRepository<AssignCourseRealization,Long> {
    public List<AssignCourseRealization> findAllByIduserAndIdcourserealization(int idUser, int idCourserealization);

}
