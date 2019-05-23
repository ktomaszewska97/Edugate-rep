package edugate.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import edugate.demo.model.UserCourseRealization;

import java.util.List;

public interface UserCourseRealizationRepository extends JpaRepository<UserCourseRealization,Long> {
    List<UserCourseRealization> findAllByIduser(int iduser);

}
