package com.example.demo.service;

import com.example.demo.entity.type.OrderStatusType;
import com.example.demo.port.IKitchenServiceMessaging;
import com.example.demo.port.IKithcenServicePublisher;
import com.fasterxml.jackson.databind.ObjectMapper;
import entity.Orders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class KitchenConsumeOrderService implements IKitchenServiceMessaging {

    @Autowired
    private KitchenEventConsumeService kitchenEventConsumeService;

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private IKithcenServicePublisher kithcenPublisher;

    @Override
    public void consumeMessage(String content) {

        try {
            Orders orderDTO=objectMapper.readValue(content, Orders.class);

            boolean started= kitchenEventConsumeService.process(orderDTO);
            kithcenPublisher.sendToOrderCallback(orderDTO);

            if(started) {
                Thread.sleep(5000);
                orderDTO.setOrderStatus(OrderStatusType.PACKAGING);
                orderDTO.setStatusDescription("Order in packaging");

                kithcenPublisher.sendToOrderCallback(orderDTO);
                kithcenPublisher.sendToDelivery(orderDTO);
            }
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}
