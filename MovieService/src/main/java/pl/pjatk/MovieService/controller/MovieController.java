package pl.pjatk.MovieService.controller;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.pjatk.MovieService.model.Movie;
import pl.pjatk.MovieService.model.MovieCategory;
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

    @PostMapping("/movies")
    public ResponseEntity<Movie> createNewMovie(@RequestBody Movie movie){
        if (movie.getId() instanceof Long &&
        movie.getName() instanceof String &&
        movie.getCategory() instanceof MovieCategory) {

            return ResponseEntity.ok(movie);
        }
        else {
            return ResponseEntity.notFound().build();
        }
        /////if cannot persist to db return 404
    }

    @PutMapping ("/movies/{id}")
    public ResponseEntity<Movie> updateMovie(@PathVariable Long id, @RequestBody Movie updateMovie) {
        Optional<Movie> movie = movieService.getMovieById(id);
        if (movie.isPresent()) {
            movie.get().setName(updateMovie.getName());
            movie.get().setCategory(updateMovie.getCategory());
            return ResponseEntity.ok(movie.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/movies/{id}")
    public ResponseEntity<Void> deleteMovie(@PathVariable Long id){
        if (movieService.deleteById(id)){
            return new ResponseEntity(HttpStatus.OK);
        }
        else return ResponseEntity.notFound().build();
    }


}
