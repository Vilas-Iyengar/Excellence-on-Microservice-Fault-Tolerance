package io.microservices.moviecatalogservice.resources;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.microservices.moviecatalogservice.models.CatalogItem;
import io.microservices.moviecatalogservice.models.Movie;
import io.microservices.moviecatalogservice.models.Rating;
import io.microservices.moviecatalogservice.service.MovieInfoService;
import io.microservices.moviecatalogservice.service.RatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.CompletableFuture;

@RestController()
@RequestMapping("/catalog")
public class MovieCatalogResources {
    @Autowired
    RestTemplate restTemplate;
    @Autowired
    MovieInfoService movieInfoService;
    @Autowired
    RatingService ratingService;

    CatalogItem catalogItem = new CatalogItem();

    @GetMapping("/{userId}")
    @CircuitBreaker(name = "catalog service",fallbackMethod = "getRatingServiceData")
    public CatalogItem getCatalog(@PathVariable String userId) {
        Rating ratings= ratingService.getMovieRatings(userId);

         Movie movie=movieInfoService.getMovieDetails(userId);

catalogItem.setDesc("Good movie");
catalogItem.setName(movie.getName());
catalogItem.setRating(ratings.getRating());


        return catalogItem;
    }

    public CatalogItem getRatingServiceData(Exception e) {
         catalogItem.setName("KGF Chapter1");
         catalogItem.setRating(10);
         catalogItem.setDesc("Excellent");
         return catalogItem;
    }
}
