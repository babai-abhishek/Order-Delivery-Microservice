package com.example.demo.service;

import com.example.demo.port.IOrderMessagePublisher;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import entity.Orders;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class OrderMessagePublishService implements IOrderMessagePublisher {

    private static final Logger logger = LoggerFactory.getLogger(OrderMessagePublishService.class);

    @Autowired
    private KafkaTemplate kafkaTemplate;

    private final static String TOPIC="orderservice";

    @Autowired
    private ObjectMapper objectMapper;

    @Override
    public void sendOrder(Orders orderDTO) {
        try {
            kafkaTemplate.send(TOPIC,objectMapper.writeValueAsString(orderDTO));
        } catch (JsonProcessingException e) {
            logger.error(e.getMessage(),e);
        }
    }
}
