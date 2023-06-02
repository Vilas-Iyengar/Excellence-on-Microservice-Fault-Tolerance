package com.hotelapp.SpringHotelApp.service;

import com.hotelapp.SpringHotelApp.model.Delivery;
import com.hotelapp.SpringHotelApp.repository.DeliveryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class DeliveryServiceImpl implements IDeliveryService{
    @Autowired
    DeliveryRepository deliveryRepository;


    @Override
    public void deleteDelivery(int deliveryId) {
        deliveryRepository.deleteById(deliveryId);
    }

    @Override
    @Transactional
    public Delivery getDeliveryById(int deliveryId) {
        return deliveryRepository.findById(deliveryId).get();
    }

    @Override
    @Transactional
    public Delivery getDeliveryByPartner(String partnerName) {

        return deliveryRepository.findByPartnerName(partnerName);
    }
}
