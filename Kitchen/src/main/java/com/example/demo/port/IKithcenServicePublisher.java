package com.example.demo.port;

import com.example.demo.entity.Orders;
import com.fasterxml.jackson.core.JsonProcessingException;

public interface IKithcenServicePublisher {

    void sendToOrderCallback(Orders orders) throws JsonProcessingException;

    void sendToDelivery(Orders orders) throws JsonProcessingException;
}
