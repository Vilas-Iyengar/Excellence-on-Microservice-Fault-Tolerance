package io.microservices.moviecatalogservice.service;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.microservices.moviecatalogservice.models.Movie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class MovieInfoService {
    @Autowired
    RestTemplate restTemplate;
     public Movie getMovieDetails(String  id){

        return restTemplate.getForObject("http://movie-info-service/movies/"+id, Movie.class);
    }

}
