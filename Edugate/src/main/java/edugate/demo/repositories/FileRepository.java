package edugate.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import edugate.demo.model.File;

public interface FileRepository extends JpaRepository<File,Long> {
}
