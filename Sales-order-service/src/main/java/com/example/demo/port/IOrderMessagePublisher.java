package com.example.demo.port;

import com.example.demo.entity.Orders;

public interface IOrderMessagePublisher {
    void sendOrder(Orders orders);
}
