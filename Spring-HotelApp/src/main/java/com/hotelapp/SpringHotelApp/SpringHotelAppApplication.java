package com.hotelapp.SpringHotelApp;

import com.hotelapp.SpringHotelApp.model.Address;
import com.hotelapp.SpringHotelApp.model.Delivery;
import com.hotelapp.SpringHotelApp.model.Hotel;
import com.hotelapp.SpringHotelApp.model.Menu;
import com.hotelapp.SpringHotelApp.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

@SpringBootApplication
public class SpringHotelAppApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(SpringHotelAppApplication.class, args);
	}
	@Autowired
	IHotelService hotelService;
	@Autowired
	IDeliveryService deliveryService;
	@Autowired
	IMenuService menuService;
	@Override
	public void run(String... args) throws Exception {


		hotelService.getHotelsByDelivery("Zomato")
				.forEach(hotel -> System.out.println(hotel.getHotelName()+" "+ hotel.getAddress().getCity()));
	}
}
