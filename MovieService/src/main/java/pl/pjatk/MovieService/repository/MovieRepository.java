package pl.pjatk.MovieService.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.pjatk.MovieService.model.Movie;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Long> {
}
