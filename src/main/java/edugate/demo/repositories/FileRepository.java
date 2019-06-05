package edugate.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import edugate.demo.model.File;

import java.awt.*;

public interface FileRepository extends JpaRepository<File,Integer> {
    public File findByIdfile(int id);
    public File findByLink(String link);
    public File findByTitle(String title);
}
