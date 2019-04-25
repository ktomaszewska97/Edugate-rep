package edugate.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import edugate.demo.model.CourseEvaluation;

public interface CourseEvaluationRepository extends JpaRepository<CourseEvaluation,Long> {
}
