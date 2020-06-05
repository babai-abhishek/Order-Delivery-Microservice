package com.example.demo.service;

import com.example.demo.dto.type.OrderStatusType;
import com.example.demo.entity.Hamburger;
import com.example.demo.entity.Orders;
import com.example.demo.port.IOrderServicePublish;
import com.example.demo.repository.OrderRepository;
import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class OrderService {

    @Autowired
    OrderRepository orderRepository;

    @Autowired
    IOrderServicePublish service;

    @Autowired
    DozerBeanMapper dozer;

    public Orders createOrder(Orders order){

        order.setOrderStatus(OrderStatusType.WAITING);

        order = orderRepository.save(order);

        service.sendOrder(order);

        return order;

    }

    public Orders getOrderById(long id){

        Optional<Orders> order = orderRepository.findById(id);

        if(order.isPresent())
            return dozer.map(order.get(),Orders.class);

        return null;
    }

    public List<Orders> getOrderList(){


        List<Orders> orders = (List<Orders>) orderRepository.findAll();

        return orders;
    }
}
