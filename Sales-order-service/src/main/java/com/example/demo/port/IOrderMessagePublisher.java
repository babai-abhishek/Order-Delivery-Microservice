package com.example.demo.port;


import entity.Orders;

public interface IOrderMessagePublisher {
    void sendOrder(Orders orders);
}
