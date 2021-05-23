package pl.pjatk.MovieService.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pl.pjatk.MovieService.model.Movie;

import java.util.List;
import java.util.Optional;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Long> {

    List<Movie> findAll();

    Optional<Movie> findById(Long id);

    Movie save(Movie movie);

    void deleteById(Long id);

    boolean existsById(Long id);

}
