package com.example.demo.entity;

import com.example.demo.dto.AddressDTO;
import com.example.demo.dto.HamburgerDTO;
import com.example.demo.dto.OrderDTO;
import com.example.demo.dto.type.CookingType;
import com.example.demo.dto.type.OrderStatusType;

import javax.persistence.*;
import java.util.List;

@Entity
public class Orders extends OrderDTO {


    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    public long getId() {
        return super.getId();
    }

    public String getStatusDescription() {
        return super.getStatusDescription();
    }

    public CookingType getCookingType() {
        return super.getCookingType();
    }

    public OrderStatusType getOrderStatus() {
        return super.getOrderStatus();
    }

   /* public List<HamburgerDTO> getHamburgerList() {
        return super.getHamburgerList();
    }*/

   @Embedded
    public AddressDTO getAddressDTO() {
        return super.getAddressDTO();
    }

    public float getPrice() {
        return super.getPrice();
    }
}
