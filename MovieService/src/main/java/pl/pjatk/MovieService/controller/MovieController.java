package pl.pjatk.MovieService.controller;


import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.pjatk.MovieService.model.Movie;
import pl.pjatk.MovieService.model.MovieCategory;
import pl.pjatk.MovieService.service.MovieService;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/movieController")
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
    public ResponseEntity<Movie> getMovieById(@PathVariable Long id) {
            return ResponseEntity.ok(movieService.getMovieById(id));
    }

    @PostMapping("/movies")
    public ResponseEntity<Movie> createNewMovie(@RequestBody Movie movie){

            return ResponseEntity.ok(movieService.addMovie(movie));

    }

    @PutMapping ("/movies/{id}")
    public ResponseEntity<Movie> updateMovie(@PathVariable Long id, @RequestBody Movie updateMovie) throws RuntimeException {
            return ResponseEntity.ok(movieService.updateMovie(id, updateMovie));
    }

    @DeleteMapping("/movies/{id}")
    public ResponseEntity<Void> deleteMovie(@PathVariable Long id){
        movieService.deleteById(id);
       return new ResponseEntity<Void>(HttpStatus.GONE);
    }

    @PutMapping("/changeAvailable")
    public ResponseEntity<Movie> changeAvailable(@RequestBody Movie movie){
        movie.setAvailable(true);
        movieService.updateMovie(movie.getId(), movie);
        return ResponseEntity.ok(movie);
    }


}
