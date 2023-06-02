package com.hotelapp.SpringHotelApp.model;


import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity

@NoArgsConstructor
@Getter
@Setter
public class Delivery {
    @Id
    @GeneratedValue(generator = "dely_id",strategy = GenerationType.AUTO)
    @SequenceGenerator(name = "dely_id",sequenceName = "delivery_id")
    private Integer deliveryId;
    private String partnerName;
    private double charges;
    @ManyToMany(mappedBy = "deliveries")
    @JsonIgnore
    private Set<Hotel> hotelSet=new HashSet<>();

    public Delivery(String partnerName, double charges ) {
        this.partnerName = partnerName;
        this.charges = charges;

    }

    @Override
    public String toString() {
        return "Delivery{" +
                "partnerName='" + partnerName + '\'' +
                ", charges=" + charges +
                '}';
    }
}
