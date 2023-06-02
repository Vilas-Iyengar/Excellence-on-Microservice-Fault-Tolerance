package com.hotelapp.SpringHotelApp.service;

import com.hotelapp.SpringHotelApp.model.Menu;

import java.util.List;

public interface IMenuService {
    List<Menu> getMenusByHotel(String hotelName);
}
