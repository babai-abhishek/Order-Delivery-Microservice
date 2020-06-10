package com.example.demo.port;

import org.springframework.kafka.annotation.KafkaListener;

public interface IdeliveryServcieMessaging {

    String TOPIC_DELIVERY="deliveryservice";

    @KafkaListener(topics = TOPIC_DELIVERY)
    void consumeMessage(String content);
}
