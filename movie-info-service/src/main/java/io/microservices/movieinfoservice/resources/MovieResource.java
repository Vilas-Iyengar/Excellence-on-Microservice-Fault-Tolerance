package io.microservices.movieinfoservice.resources;
import io.microservices.movieinfoservice.models.Movies;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/movies")
public class MovieResource {

    @GetMapping("/{movieId}")
    public Movies getMovie(@PathVariable String movieId) {

        return new Movies(movieId, "Kantara");
    }

}

