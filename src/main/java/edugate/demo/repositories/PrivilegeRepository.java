package edugate.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import edugate.demo.model.Privilege;

public interface PrivilegeRepository extends JpaRepository<Privilege,Long> {
}
