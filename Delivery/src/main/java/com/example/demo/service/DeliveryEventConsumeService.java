package com.example.demo.service;

import com.example.demo.entity.Address;
import com.example.demo.entity.Orders;
import com.example.demo.entity.type.OrderStatusType;
import com.example.demo.port.IDeliveryServicePublisher;
import com.example.demo.port.IdeliveryServcieMessaging;
import com.example.demo.repository.DeliveryRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class DeliveryEventConsumeService  implements IdeliveryServcieMessaging {

    @Autowired
    private IDeliveryServicePublisher deliveryPublisher;

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private DeliveryRepository deliveryRepository;

    @Override
    public void consumeMessage(String content) {
        try {
            Orders orders = objectMapper.readValue(content, Orders.class);
            Address address =new Address();
            address.setNumber(orders.getNumber());
            address.setStreet(orders.getStreet());
            address.setOrderId(String.valueOf(orders.getOrderId()));
            deliveryRepository.save(address);
            Thread.sleep(5000);
            orders.setOrderStatus(OrderStatusType.DELIVERED);
            orders.setStatusDescription("Delivered");
            deliveryPublisher.sendToOrderCallback(orders);

        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}
