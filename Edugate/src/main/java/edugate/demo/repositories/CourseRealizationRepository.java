package edugate.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import edugate.demo.model.CourseRealization;

public interface CourseRealizationRepository extends JpaRepository<CourseRealization,Long>
{
}
