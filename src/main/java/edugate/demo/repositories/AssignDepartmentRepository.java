package edugate.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import edugate.demo.model.AssignDepartment;

public interface AssignDepartmentRepository extends JpaRepository<AssignDepartment,Long> {
}
