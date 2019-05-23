package edugate.demo.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import edugate.demo.model.UserCourse;
import edugate.demo.model.Users;

public interface UserCourseRepository extends JpaRepository<UserCourse,Integer> {

	public List<UserCourse> findByIduser(int iduser);
	
	public List<UserCourse> findByIdcourserealization(int idcourserealization);
}
