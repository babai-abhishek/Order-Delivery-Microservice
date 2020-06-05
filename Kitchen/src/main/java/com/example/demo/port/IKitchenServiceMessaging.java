package com.example.demo.port;

import org.springframework.kafka.annotation.KafkaListener;


public interface IKitchenServiceMessaging {

    String ORDER_TOPIC="orderservice";

    @KafkaListener(topics = ORDER_TOPIC)
    void consumeMessage(String content);
}
