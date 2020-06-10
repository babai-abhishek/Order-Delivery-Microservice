package com.example.demo.port;

import entity.Hamburger;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


public interface IKitchenServiceApi {

    @ApiOperation(value = "Add hamburger", response = Void.class)
    @RequestMapping(value = "add", produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.POST)
    void addHamburger(@RequestBody Hamburger hamburgerDTO);
}
