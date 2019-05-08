package edugate.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import edugate.demo.model.UserProfile;

public interface UserProfileRepository extends JpaRepository<UserProfile,Long> {

}
