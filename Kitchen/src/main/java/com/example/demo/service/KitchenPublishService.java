package com.example.demo.service;

import com.example.demo.entity.Orders;
import com.example.demo.port.IKithcenServicePublisher;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class KitchenPublishService implements IKithcenServicePublisher {


    private final static String TOPIC_ORDER_CALLBACK ="orderservicecallback";

    private final static String TOPIC_DELIVERY="deliveryservice";

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private KafkaTemplate kafkaTemplate;


    @Override
    public void sendToOrderCallback(Orders orders) throws JsonProcessingException{
        kafkaTemplate.send(TOPIC_ORDER_CALLBACK,objectMapper.writeValueAsString(orders));
    }

    @Override
    public void sendToDelivery(Orders orders) throws JsonProcessingException {
        kafkaTemplate.send(TOPIC_DELIVERY,objectMapper.writeValueAsString(orders));
    }

}
