package edugate.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import edugate.demo.model.Administrator;

public interface AdministratorRepository extends JpaRepository<Administrator,Long> {
}
