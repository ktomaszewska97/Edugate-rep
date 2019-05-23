package edugate.demo.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import edugate.demo.model.Users;

public interface UsersRepository extends JpaRepository<Users,Integer> {
	
    public Users findByLogin(String login);

    public Users findByEmail(String email);
    
    public List<Users> findByAccounttype(int accounttype);
}
