package com.hotelapp.SpringHotelApp.model;

import com.fasterxml.jackson.annotation.*;
import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;
@Entity
@Getter
@Setter
@NoArgsConstructor
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class,property = "menuId")

public class Menu {
    @Id
    @GeneratedValue(generator = "menu_id",strategy = GenerationType.AUTO)
    @SequenceGenerator(name = "menu_id",sequenceName = "menu_id")

    private Integer menuId;
    private String menuName;
    private double price;
    @ManyToOne
    @JoinColumn(name = "hotel_id")
    @JsonIgnore
    private Hotel hotel;

    public Menu(String menuName, double price) {
        this.menuName = menuName;
        this.price = price;

    }

    @Override
    public String toString() {
        return "Menu{" +
                "menuName='" + menuName + '\'' +
                ", price=" + price +
                '}';
    }
}
