package edugate.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import edugate.demo.model.AssignSchool;

public interface AssignSchoolRepository extends JpaRepository<AssignSchool,Long> {
}
