package com.example.demo.port;

import com.fasterxml.jackson.core.JsonProcessingException;
import entity.Orders;

public interface IDeliveryServicePublisher {

    void sendToOrderCallback(Orders orders) throws JsonProcessingException;

}
