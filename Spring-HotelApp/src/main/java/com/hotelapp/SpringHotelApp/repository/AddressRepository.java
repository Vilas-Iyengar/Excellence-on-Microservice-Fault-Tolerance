package com.hotelapp.SpringHotelApp.repository;

import com.hotelapp.SpringHotelApp.model.Address;
import com.hotelapp.SpringHotelApp.model.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressRepository extends JpaRepository<Address,Integer> {

}
