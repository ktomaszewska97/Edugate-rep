package edugate.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import edugate.demo.model.Course;

public interface CourseRepository extends JpaRepository<Course,Integer> {
}
