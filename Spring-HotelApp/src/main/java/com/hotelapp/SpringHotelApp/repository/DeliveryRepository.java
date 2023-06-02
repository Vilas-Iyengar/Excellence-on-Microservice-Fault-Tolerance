package com.hotelapp.SpringHotelApp.repository;

import com.hotelapp.SpringHotelApp.model.Delivery;
import com.hotelapp.SpringHotelApp.model.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DeliveryRepository extends JpaRepository<Delivery,Integer> {

    Delivery findByPartnerName(String partnerName);
}
