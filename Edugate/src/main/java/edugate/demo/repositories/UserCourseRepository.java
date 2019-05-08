package edugate.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import edugate.demo.model.UserCourse;

public interface UserCourseRepository extends JpaRepository<UserCourse,Integer> {
}
