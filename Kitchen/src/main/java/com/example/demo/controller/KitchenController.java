package com.example.demo.controller;

import com.example.demo.entity.Hamburger;
import com.example.demo.port.IKitchenServiceApi;
import com.example.demo.service.KitchenService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping("/kitchen/")
@Api(tags = "KitchenServices")
public class KitchenController implements IKitchenServiceApi {

    @Autowired
    KitchenService kitchenService;

    @Override
    public void addHamburger(Hamburger hamburger) {
        kitchenService.addHamburger(hamburger);
    }
}
