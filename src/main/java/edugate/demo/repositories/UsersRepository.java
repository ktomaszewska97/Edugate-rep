package edugate.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import edugate.demo.model.Users;

public interface UsersRepository extends JpaRepository<Users,Long> {

}
