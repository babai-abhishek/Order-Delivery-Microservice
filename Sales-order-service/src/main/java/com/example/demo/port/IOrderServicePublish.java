package com.example.demo.port;

import com.example.demo.dto.OrderDTO;

public interface IOrderServicePublish {
    void sendOrder(OrderDTO orderDTO);
}
