package com.example.demo.service;

import com.example.demo.entity.Orders;
import com.example.demo.port.IOrderMessageConsumer;
import com.example.demo.repository.OrderRepository;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.Optional;

@Service
public class OrderMessageConsumeService implements IOrderMessageConsumer {

        @Autowired
        private ObjectMapper mapper;

        @Autowired
        private OrderRepository orderRepository;

        @Override
        public void callback(String message){
            try {
                Orders orders=mapper.readValue(message, Orders.class);
                Optional<Orders> orderOptional=orderRepository.findById(orders.getOrderId());
                if(orderOptional.isPresent())
                {
                    Orders order=orderOptional.get();
                    order.setStatusDescription(orders.getStatusDescription());
                    order.setOrderStatus(orders.getOrderStatus());
                    orderRepository.save(order);
                }
            }  catch (IOException e) {
                e.printStackTrace();
            }
        }

}
