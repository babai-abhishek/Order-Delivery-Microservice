package com.example.demo.controller;

import com.example.demo.dto.OrderDTO;
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
    public OrderDTO create(OrderDTO orderDTO) {
        return orderService.createOrder(orderDTO);
    }

    @Override
    public OrderDTO view(String id) {
        return orderService.getOrderById(id);
    }

    @Override
    public List<OrderDTO> viewAll() {
        return orderService.getOrderList();
    }
}
