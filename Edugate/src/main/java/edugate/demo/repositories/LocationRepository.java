package edugate.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import edugate.demo.model.Location;

public interface LocationRepository extends JpaRepository<Location,Long> {
}
