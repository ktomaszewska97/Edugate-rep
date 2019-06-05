package edugate.demo.repositories;

import edugate.demo.model.File;
import org.springframework.data.jpa.repository.JpaRepository;

import edugate.demo.model.FileComment;

public interface FileCommentRepository extends JpaRepository<FileComment,Long> {

}
