package com.hotelapp.SpringHotelApp.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor


@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class,property = "hotelId")
public class Hotel {
    @Id
    @GeneratedValue(generator = "hotel_id",strategy = GenerationType.AUTO)
    @SequenceGenerator(name = "hotel_id",sequenceName = "hotel_id")
    private Integer hotelId;
    private String hotelName;
    @OneToOne(cascade = CascadeType.ALL )
    @JoinColumn(name = "address_id")
    private Address address;
    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    @JoinColumn(name = "hotel_id")

    private Set<Menu> menuSet;
    @ManyToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    @JoinTable(name = "hotel_deliveries",joinColumns = @JoinColumn(name = "hotel_id"),inverseJoinColumns = @JoinColumn(name="delivery_id"))
    private Set<Delivery> deliveries;

    public Hotel(String hotelName, Address address, Set<Menu> menuSet, Set<Delivery> deliveries) {
        this.hotelName = hotelName;
        this.address = address;
        this.menuSet = menuSet;
        this.deliveries = deliveries;
    }

       @Override
    public String toString() {
        return "Hotel{" +
                "hotelName='" + hotelName + '\'' +
                ", address=" + address +
                ", menuSet=" + menuSet +
                ", deliveries=" + deliveries +
                '}';
    }
}
