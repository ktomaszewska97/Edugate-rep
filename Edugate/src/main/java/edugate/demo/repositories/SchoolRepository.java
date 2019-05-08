package edugate.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import edugate.demo.model.School;

@Service
public interface SchoolRepository extends JpaRepository<School,Long> {


}
