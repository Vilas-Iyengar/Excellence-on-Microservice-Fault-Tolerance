package com.hotelapp.SpringHotelApp.model;

import lombok.*;

import javax.persistence.*;

@Entity

@NoArgsConstructor
@Getter
@Setter
public class Address {
    @Id
    @GeneratedValue(generator = "add_id",strategy = GenerationType.AUTO)
    @SequenceGenerator(name = "add_id",sequenceName = "address_id")
    private Integer addressId;
    private String streetName;
    private String city;
    private String state;
    private long zipcode;

    public Address(String streetName, String city, String state, long zipcode) {
        this.streetName = streetName;
        this.city = city;
        this.state = state;
        this.zipcode = zipcode;
    }

    @Override
    public String toString() {
        return "Address{" +
                "streetName='" + streetName + '\'' +
                ", city='" + city + '\'' +
                ", state='" + state + '\'' +
                ", zipcode=" + zipcode +
                '}';
    }
}
