package com.example.demo.service;

import com.example.demo.dto.OrderDTO;
import com.example.demo.dto.type.OrderStatusType;
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

    public OrderDTO createOrder(OrderDTO orderDTO){

        Orders orders =new Orders();
        dozer.map(orderDTO, orders);
        orders.setOrderStatus(OrderStatusType.WAITING);
        orders.setStatusDescription(OrderStatusType.WAITING.name());

        orders =orderRepository.save(orders);

        service.sendOrder(orders);

        OrderDTO dto=dozer.map(orders,OrderDTO.class);

        return dto;

    }

    public OrderDTO getOrderById(String id){

        Optional<Orders> order = orderRepository.findById(id);

        if(order.isPresent())
            return dozer.map(order.get(),OrderDTO.class);

        return null;
    }

    public List<OrderDTO> getOrderList(){

        List<OrderDTO> orderDTOS = new ArrayList<>();

        List<Orders> orders = (List<Orders>) orderRepository.findAll();

        for(Orders order : orders){
            orderDTOS.add(dozer.map(order,OrderDTO.class));
        }

        return orderDTOS;
    }
}
