package pl.pjatk.MovieService.controller;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.pjatk.MovieService.model.Movie;
import pl.pjatk.MovieService.service.MovieService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/movieservice")
public class MovieController {

   private final MovieService movieService;

    public MovieController(MovieService movieService){
        this.movieService = movieService;
    }


@GetMapping("/movies")
    public ResponseEntity<List<Movie>> listOfMovies(){
    return ResponseEntity.ok(movieService.getAllMovies());
    }


    @GetMapping ("/movies/{id}")
    public ResponseEntity<Movie> getMovieById(@PathVariable Long id){
        Optional<Movie> movie = movieService.getMovieById(id);
        if (movie.isPresent()){
            return ResponseEntity.ok(movie.get());
        }
        else {
            return ResponseEntity.notFound().build();
        }
    }
}
