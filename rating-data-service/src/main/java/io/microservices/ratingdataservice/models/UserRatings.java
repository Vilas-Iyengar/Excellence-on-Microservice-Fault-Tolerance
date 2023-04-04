package io.microservices.ratingdataservice.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserRatings {
    private List<Rating> userRatings=new ArrayList<>();
}
