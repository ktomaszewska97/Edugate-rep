package edugate.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import edugate.demo.model.AssignFileToDepartment;

public interface AssignFileToDepartmentRepository extends JpaRepository<AssignFileToDepartment,Long> {
}
