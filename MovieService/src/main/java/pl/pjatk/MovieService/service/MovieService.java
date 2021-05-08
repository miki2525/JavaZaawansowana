package pl.pjatk.MovieService.service;

import org.springframework.stereotype.Service;
import pl.pjatk.MovieService.model.Movie;
import pl.pjatk.MovieService.model.MovieCategory;

import java.util.List;
import java.util.Optional;

@Service
public class MovieService {

    public List<Movie> getAllMovies(){
        return List.of(
                new Movie(1l, "Scream", MovieCategory.Horror),
                new Movie(2l, "SpaceJam", MovieCategory.Comedy),
                new Movie(3l, "LordOfTheRings", MovieCategory.Fantasy),
                new Movie(4l, "XXX", MovieCategory.Action)
                );
    }

    public Optional<Movie> getMovieById(Long id){
        List<Movie> movieList = List.of(
                new Movie(1l, "Scream", MovieCategory.Horror),
                new Movie(2l, "SpaceJam", MovieCategory.Comedy),
                new Movie(3l, "LordOfTheRings", MovieCategory.Fantasy),
                new Movie(4l, "XXX", MovieCategory.Action)
        );

        return movieList.stream().
                filter(movie -> movie.getId() == id).findFirst();

    }
}
