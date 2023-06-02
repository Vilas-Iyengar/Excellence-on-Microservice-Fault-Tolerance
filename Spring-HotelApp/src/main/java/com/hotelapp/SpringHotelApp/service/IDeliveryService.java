package com.hotelapp.SpringHotelApp.service;

import com.hotelapp.SpringHotelApp.model.Delivery;

public interface IDeliveryService {

    void deleteDelivery(int deliveryId);
    Delivery getDeliveryById(int deliveryId);
    Delivery getDeliveryByPartner(String partnerName);
}
