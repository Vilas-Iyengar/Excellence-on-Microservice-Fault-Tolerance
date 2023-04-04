package io.microservices.ratingdataservice.resources;

import io.microservices.ratingdataservice.models.Rating;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/ratings")
public class RatingResource {
    @GetMapping("/{movieId}")
    public Rating getRating(@PathVariable String movieId) {

        return new Rating(movieId, 9);
    }
}
