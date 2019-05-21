package edugate.demo.repositories;

import java.util.List;

import edugate.demo.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;

import edugate.demo.model.Comment;
import edugate.demo.model.UserProfile;

public interface UserProfileRepository extends JpaRepository<UserProfile,Integer> {
	
	List<UserProfile> findAllByIduser(int idUser);

	public UserProfile findByIduser(int idUser);
}
