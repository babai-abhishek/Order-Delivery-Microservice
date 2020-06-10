package com.example.demo.port;

import com.example.demo.entity.Address;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

public interface IDeliveryServiceApi {

    @ApiOperation(value = "View delivery status", response = Address.class,responseContainer = "list")
    @RequestMapping(value = "status", produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.GET)
    @ResponseBody
    List<Address> status();
}
