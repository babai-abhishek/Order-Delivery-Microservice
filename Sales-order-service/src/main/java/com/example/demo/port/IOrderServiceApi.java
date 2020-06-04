package com.example.demo.port;

import com.example.demo.entity.Orders;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public interface IOrderServiceApi {

    @ApiOperation(value = "Create order", response = Orders.class)
    @RequestMapping(value = "create", produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.POST)
    Orders create(@RequestBody Orders request);

    @ApiOperation(value = "View order", response = Orders.class)
    @RequestMapping(value = "view/{id}", produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.GET)
    @ResponseBody
    Orders view(@PathVariable String id);

    @ApiOperation(value = "All orders", response = Orders.class,responseContainer = "list")
    @RequestMapping(value = "view", produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.GET)
    @ResponseBody
    List<Orders> viewAll();
}
