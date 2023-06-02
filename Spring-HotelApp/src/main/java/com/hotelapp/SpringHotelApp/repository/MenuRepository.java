package com.hotelapp.SpringHotelApp.repository;

import com.hotelapp.SpringHotelApp.model.Hotel;
import com.hotelapp.SpringHotelApp.model.Menu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MenuRepository extends JpaRepository<Menu,Integer> {

    List<Menu> findByHotelHotelName(String hotelName);
}
