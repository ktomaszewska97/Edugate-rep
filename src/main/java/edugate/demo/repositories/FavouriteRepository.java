package edugate.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import edugate.demo.model.Favourite;

public interface FavouriteRepository extends JpaRepository<Favourite,Long> {
}
