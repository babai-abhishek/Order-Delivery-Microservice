package com.example.demo.port;

import com.example.demo.entity.Orders;

public interface IOrderServicePublish {
    void sendOrder(Orders orders);
}
