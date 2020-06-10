package com.example.demo.port;

import org.springframework.kafka.annotation.KafkaListener;

public interface IOrderMessageConsumer {

    String TOPIC_ORDER_CALLBACK ="orderservicecallback";

    @KafkaListener(topics = TOPIC_ORDER_CALLBACK)
    void callback(String message);
}
