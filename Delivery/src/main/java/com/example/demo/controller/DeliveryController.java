package com.example.demo.controller;

import com.example.demo.entity.Address;
import com.example.demo.port.IDeliveryServiceApi;
import com.example.demo.service.DeliveryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class DeliveryController implements IDeliveryServiceApi {

    @Autowired
    DeliveryService deliveryService;

    @Override
    public List<Address> status() {
        return deliveryService.getAll();
    }
}
