package edugate.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import edugate.demo.model.Comment;

public interface CommentRepository extends JpaRepository<Comment,Long> {
}
