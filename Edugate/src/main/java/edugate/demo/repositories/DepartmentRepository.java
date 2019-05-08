package edugate.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import edugate.demo.model.Department;

public interface DepartmentRepository extends JpaRepository<Department,Long> {
}
