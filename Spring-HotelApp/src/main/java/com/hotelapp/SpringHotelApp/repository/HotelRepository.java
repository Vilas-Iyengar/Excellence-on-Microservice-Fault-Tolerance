package com.hotelapp.SpringHotelApp.repository;

import com.hotelapp.SpringHotelApp.model.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HotelRepository extends JpaRepository<Hotel,Integer> {

    List<Hotel> findByAddressCity(String city);
   List<Hotel> findByAddressStreetName(String location);
   List<Hotel> findByMenuSetMenuName(String menuName);
   List<Hotel> findByDeliveriesPartnerName(String partnerName);
   List<Hotel> findByAddressStreetNameAndMenuSetMenuName(String location,String menuName);
}
