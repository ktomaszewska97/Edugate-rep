package edugate.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import edugate.demo.model.FieldOfStudy;

public interface FieldOfStudyRepository extends JpaRepository<FieldOfStudy,Long> {
}
