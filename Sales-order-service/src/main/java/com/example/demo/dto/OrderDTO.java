package com.example.demo.dto;


import com.example.demo.dto.type.CookingType;
import com.example.demo.dto.type.OrderStatusType;

import java.util.List;

public class OrderDTO {

    private long id;

    private String statusDescription;

    private CookingType cookingType;

    private OrderStatusType orderStatus;

    private List<HamburgerDTO> hamburgerList;

    private AddressDTO addressDTO;

    private float price;

    public List<HamburgerDTO> getHamburgerList() {
        return hamburgerList;
    }

    public void setHamburgerList(List<HamburgerDTO> hamburgerList) {
        this.hamburgerList = hamburgerList;
    }

    public AddressDTO getAddressDTO() {
        return addressDTO;
    }

    public void setAddressDTO(AddressDTO addressDTO) {
        this.addressDTO = addressDTO;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public OrderStatusType getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(OrderStatusType orderStatus) {
        this.orderStatus = orderStatus;
    }

    public String getStatusDescription() {
        return statusDescription;
    }

    public void setStatusDescription(String statusDescription) {
        this.statusDescription = statusDescription;
    }

    public CookingType getCookingType() {
        return cookingType;
    }

    public void setCookingType(CookingType cookingType) {
        this.cookingType = cookingType;
    }
}
