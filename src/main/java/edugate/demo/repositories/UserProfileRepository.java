package edugate.demo.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import edugate.demo.model.Comment;
import edugate.demo.model.UserProfile;

public interface UserProfileRepository extends JpaRepository<UserProfile,Integer> {
	
	List<UserProfile> findByIduser(int idUser);
}
