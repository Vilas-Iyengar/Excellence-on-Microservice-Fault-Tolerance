package io.microservices.moviecatalogservice.service;

import io.microservices.moviecatalogservice.models.Rating;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class RatingService {

    @Autowired
    RestTemplate restTemplate;

    public Rating getMovieRatings(String  id){
        return restTemplate.getForObject("http://rating-data-service/ratings/"+id, Rating.class);
    }

}
