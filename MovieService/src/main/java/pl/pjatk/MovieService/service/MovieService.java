package pl.pjatk.MovieService.service;

import exception.MovieNotFoundException;
import org.springframework.stereotype.Service;
import pl.pjatk.MovieService.model.Movie;
import pl.pjatk.MovieService.repository.MovieRepository;

import java.util.List;

@Service
public class MovieService {
    private MovieRepository movieRepository;

    public MovieService(MovieRepository movieRepository){
        this.movieRepository = movieRepository;
    }

    public List<Movie> getAllMovies(){
        return movieRepository.findAll();
    }

    public Movie getMovieById(Long id) throws MovieNotFoundException {
        return movieRepository.findById(id)
                .orElseThrow(MovieNotFoundException::new);
    }

    public void addMovie(Movie movie){
        movieRepository.save(movie);
    }

    public void deleteById(Long id){
        movieRepository.deleteById(id);
    }

    public void delete(Long id){
        movieRepository.deleteById(id);
    }

    public Movie updateMovie(Movie movie){
        if(movieRepository.existsById(movie.getId())){
             return movieRepository.save(movie);}
            else {
                throw new RuntimeException();
            }
    }

}
