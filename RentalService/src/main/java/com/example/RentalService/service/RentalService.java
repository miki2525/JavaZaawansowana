package com.example.RentalService.service;

import com.example.RentalService.model.Movie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class RentalService {


    private RestTemplate restTemplate;

    public RentalService(RestTemplate restTemplate){
        this.restTemplate = restTemplate;
    }

    public Movie getMovie(Long id){
        String urlRequest = "http://localhost:8080/movieController/movies/";
        return restTemplate.getForObject(urlRequest + id, Movie.class);
    }

    public void returnMovie(Long id){
        String urlRequest = "http://localhost:8080/movieController/changeAvailable/";
        restTemplate.put(urlRequest + id, Movie.class);
    }

    public void rentMovie(Long id){
        String urlRequest = "http://localhost:8080/movieController/changeAvailableFalse/";
        restTemplate.put(urlRequest + id, Movie.class);
    }
}
