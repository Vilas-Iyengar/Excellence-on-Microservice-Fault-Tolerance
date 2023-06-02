package com.hotelapp.SpringHotelApp.service;

import com.hotelapp.SpringHotelApp.exception.HotelNotFoundException;
import com.hotelapp.SpringHotelApp.exception.IdNotFoundException;
import com.hotelapp.SpringHotelApp.model.Hotel;

import java.util.List;

public interface IHotelService {
    Hotel addHotel(Hotel hotel);
    void updateHotel(Hotel hotel);
    Hotel getHotelById(int hotelId) throws IdNotFoundException;
    void deleteHotelById(int hotelId) throws IdNotFoundException;

    List<Hotel> getHotelsByCity(String city) throws HotelNotFoundException;
    List<Hotel> getHotelsByMenu(String menuName) throws HotelNotFoundException;
    List<Hotel> getHotelsByDelivery(String partnerName) throws HotelNotFoundException;
    List<Hotel> getHotelsByLocation(String location) throws HotelNotFoundException;
    List<Hotel> getHotelsByLocationAndMenu(String location,String menuName)throws HotelNotFoundException;
}
