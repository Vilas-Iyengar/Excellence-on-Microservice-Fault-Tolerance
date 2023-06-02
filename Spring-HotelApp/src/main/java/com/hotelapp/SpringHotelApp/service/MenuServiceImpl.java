package com.hotelapp.SpringHotelApp.service;

import com.hotelapp.SpringHotelApp.model.Menu;
import com.hotelapp.SpringHotelApp.repository.MenuRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class MenuServiceImpl implements IMenuService{
    @Autowired
    MenuRepository menuRepository;
    @Override
    public List<Menu> getMenusByHotel(String hotelName) {
        return menuRepository.findByHotelHotelName(hotelName);
    }
}
