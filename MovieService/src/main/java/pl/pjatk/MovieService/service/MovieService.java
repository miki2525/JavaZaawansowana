package pl.pjatk.MovieService.service;

import org.springframework.stereotype.Service;
import pl.pjatk.MovieService.model.Movie;
import pl.pjatk.MovieService.model.MovieCategory;

import java.util.List;

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
}
