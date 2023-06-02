package com.hotelapp.SpringHotelApp.service;

import com.hotelapp.SpringHotelApp.exception.HotelNotFoundException;
import com.hotelapp.SpringHotelApp.exception.IdNotFoundException;
import com.hotelapp.SpringHotelApp.model.Hotel;
import com.hotelapp.SpringHotelApp.repository.HotelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HotelServiceImpl implements IHotelService {

    @Autowired
    HotelRepository hotelRepository;

    @Override
    public Hotel addHotel(Hotel hotel) {
        return hotelRepository.save(hotel);
    }

    @Override
    public void updateHotel(Hotel hotel) {
        hotelRepository.save(hotel);
    }

    @Override
    public Hotel getHotelById(int hotelId) {
        return hotelRepository.findById(hotelId).orElseThrow(()->new IdNotFoundException("Id Not Found"));

    }

    @Override
    public void deleteHotelById(int hotelId) {
        hotelRepository.deleteById(hotelId);
    }

    @Override
    public List<Hotel> getHotelsByCity(String city) {

        List<Hotel> hotelList= hotelRepository.findByAddressCity(city);
        if(hotelList.isEmpty()){
            throw new HotelNotFoundException("Hotel with city not found");
        }
        else{
            return hotelList;
        }
    }

    @Override
    public List<Hotel> getHotelsByMenu(String menuName) {

        List<Hotel> hotelList= hotelRepository.findByMenuSetMenuName(menuName);
        if(hotelList.isEmpty()){
            throw new HotelNotFoundException("Hotel with menu name not found");
        }
        else{
            return hotelList;
        }
    }

    @Override
    public List<Hotel> getHotelsByDelivery(String partnerName) {
        List<Hotel> hotelList= hotelRepository.findByDeliveriesPartnerName(partnerName);
        if(hotelList.isEmpty()){
            throw new HotelNotFoundException("Hotel with partner name not found");
        }
        else{
            return hotelList;
        }    }

    @Override
    public List<Hotel> getHotelsByLocation(String location) {
        List<Hotel> hotelList= hotelRepository.findByAddressStreetName(location);
        if(hotelList.isEmpty()){
            throw new HotelNotFoundException("Hotel with location not found");
        }
        else{
            return hotelList;
        }    }

    @Override
    public List<Hotel> getHotelsByLocationAndMenu(String location, String menuName) {

        List<Hotel> hotelList= hotelRepository.findByAddressStreetNameAndMenuSetMenuName(location,menuName);
        if(hotelList.isEmpty()){
            throw new HotelNotFoundException("Hotel with location and menu  not found");
        }
        else{
            return hotelList;
        }
    }
}
