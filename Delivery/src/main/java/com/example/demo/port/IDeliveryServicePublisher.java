package com.example.demo.port;

import com.example.demo.entity.Orders;
import com.fasterxml.jackson.core.JsonProcessingException;

public interface IDeliveryServicePublisher {

    void sendToOrderCallback(Orders orders) throws JsonProcessingException;

}
