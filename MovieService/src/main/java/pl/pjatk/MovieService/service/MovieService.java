package pl.pjatk.MovieService.service;

import org.springframework.stereotype.Service;
import pl.pjatk.MovieService.model.Movie;
import pl.pjatk.MovieService.model.MovieCategory;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class MovieService {

    private List<Movie> movieList = new ArrayList<>(List.of(
                new Movie(1l, "Scream", MovieCategory.Horror),
                new Movie(2l, "SpaceJam", MovieCategory.Comedy),
                new Movie(3l, "LordOfTheRings", MovieCategory.Fantasy),
                new Movie(4l, "XXX", MovieCategory.Action)));

    public List<Movie> getAllMovies(){
        return movieList;
    }

    public Optional<Movie> getMovieById(Long id){
        return movieList.stream()
                .filter(movie -> movie.getId() == id)
                .findAny();
    }

    public void addMovie(Movie movie){
        movieList.add(movie);
    }

    public Boolean deleteById(Long id){
        Optional<Movie> movie = getMovieById(id);
        if (movie.isPresent()){
            movieList.remove(movie.get());
            return true;
        }
        return false;
    }
}
