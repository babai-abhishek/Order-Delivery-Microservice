package com.example.demo.port;

import com.fasterxml.jackson.core.JsonProcessingException;
import entity.Orders;

public interface IKithcenServicePublisher {

    void sendToOrderCallback(Orders orders) throws JsonProcessingException;

    void sendToDelivery(Orders orders) throws JsonProcessingException;
}
