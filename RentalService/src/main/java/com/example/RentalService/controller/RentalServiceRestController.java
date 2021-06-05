package com.example.RentalService.controller;

import com.example.RentalService.model.Movie;
import com.example.RentalService.service.RentalService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/")
public class RentalServiceRestController {

    RentalService rentalService;

    public RentalServiceRestController(RentalService rentalService){
        this.rentalService = rentalService;
    }

    @GetMapping("/movie/{id}")
public ResponseEntity<Movie> getMyMovie(@PathVariable Long id){
        return  ResponseEntity.ok(rentalService.getMovie(id));
    }

    @PutMapping("/setAvailable/{id}")
    public ResponseEntity<Movie> setAvailable(@PathVariable Long id){
        rentalService.returnMovie(id);
        return  ResponseEntity.ok(rentalService.getMovie(id));
    }

}
