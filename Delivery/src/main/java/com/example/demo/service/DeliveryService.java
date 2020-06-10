package com.example.demo.service;

import com.example.demo.entity.Address;
import com.example.demo.repository.DeliveryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeliveryService {

    @Autowired
    DeliveryRepository repository;


    public List<Address> getAll(){

        List<Address> addressList = (List<Address>) repository.findAll();

        return addressList;
    }
}
