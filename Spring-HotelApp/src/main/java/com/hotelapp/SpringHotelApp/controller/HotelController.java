package com.hotelapp.SpringHotelApp.controller;

import com.hotelapp.SpringHotelApp.model.Hotel;
import com.hotelapp.SpringHotelApp.service.HotelServiceImpl;
import com.hotelapp.SpringHotelApp.service.IHotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/hotels-restapi")
public class HotelController {
    @Autowired
    IHotelService hotelService;
    @GetMapping("/hotels/hotels-by-id/{id}")
    public ResponseEntity<Hotel> getHotelById(@PathVariable int id){
       Hotel hotel=  hotelService.getHotelById(id);
        HttpHeaders headers=new HttpHeaders();
        headers.add("desc","getting one hotel by id");
        return ResponseEntity.ok().headers(headers).body(hotel);
    }
    @PostMapping("/hotels")
    public ResponseEntity<Hotel> addHotel(@RequestBody Hotel hotel){
        Hotel newHotel=hotelService.addHotel(hotel);
        HttpHeaders headers=new HttpHeaders();
        headers.add("desc","One hotel added");
        return ResponseEntity.ok().headers(headers).body(newHotel);
    }
    @PutMapping("/hotels")
    public ResponseEntity<String> updateHotel(@RequestBody Hotel hotel){
        hotelService.updateHotel(hotel);
        return ResponseEntity.ok("Updated Successfully");
    }
    @DeleteMapping("/hotels/delete-hotels-by-id/{id}")
    public ResponseEntity<Void> deleteHotel(@PathVariable int id){
        hotelService.deleteHotelById(id);
        return ResponseEntity.ok().build();
    }
    @GetMapping("/hotels/hotels-by-city/{city}")
    public ResponseEntity<List<Hotel>> getHotelsByCity(@PathVariable String city){
        List<Hotel> hotels= hotelService.getHotelsByCity(city);
        return ResponseEntity.ok().body(hotels);
    }
    @GetMapping("/hotels/hotels-by-menu/{menuName}")
    public ResponseEntity<List<Hotel>> getHotelsByMenu(@PathVariable String menuName){
       List<Hotel> hotelList=hotelService.getHotelsByMenu(menuName);
       return ResponseEntity.ok().body(hotelList);
    }
    @GetMapping("/hotels/hotels-by-delivery/{partnerName}")
    public ResponseEntity<List<Hotel>> getHotelsByDeleivery(@PathVariable String partnerName){
        List<Hotel> hotelList=hotelService.getHotelsByDelivery(partnerName);
        return ResponseEntity.ok().body(hotelList);
    }
    @GetMapping("/hotels/hotels-by-location/{location}")
    public ResponseEntity<List<Hotel>> getHotelsByLocation(@PathVariable String location){
        List<Hotel> hotelList=hotelService.getHotelsByLocation(location);
        return ResponseEntity.ok().body(hotelList);
    }
    @GetMapping("/hotels/hotels-by-location/{location}/menu-name/{menuName}")
    public ResponseEntity<List<Hotel>> getHotelsByLocationAndMenu(@PathVariable String location,@PathVariable String menuName){
        List<Hotel> hotelList=hotelService.getHotelsByLocationAndMenu(location,menuName);
        return ResponseEntity.ok().body(hotelList);
    }




}
