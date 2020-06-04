package com.example.demo.controller;

import com.example.demo.entity.Orders;
import com.example.demo.port.IOrderServiceApi;
import com.example.demo.service.OrderService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/order/")
@Api(tags = "OrderServices")
public class OrderController implements IOrderServiceApi {

    @Autowired
    OrderService orderService;

    @Override
    public Orders create(Orders orders) {
        return orderService.createOrder(orders);
    }

    @Override
    public Orders view(String id) {
        return orderService.getOrderById(Long.parseLong(id));
    }

    @Override
    public List<Orders> viewAll() {
        return orderService.getOrderList();
    }
}
