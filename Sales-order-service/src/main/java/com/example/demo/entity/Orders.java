package com.example.demo.entity;

import com.example.demo.dto.type.CookingType;
import com.example.demo.dto.type.OrderStatusType;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.List;

@Entity
public class Orders {


    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private long orderId;

    private String statusDescription;

    @OneToMany(mappedBy = "orders", cascade = CascadeType.ALL,
            fetch=FetchType.LAZY)
    @JsonManagedReference
    private List<Hamburger> hamburgerList;

    private CookingType cookingType;

    private OrderStatusType orderStatus;

    private String number;

    private String street;

    private int price;

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }


    public String getStatusDescription() {
        return statusDescription;
    }

    public void setStatusDescription(String statusDescription) {
        this.statusDescription = statusDescription;
    }

    public long getOrderId() {
        return orderId;
    }

    public void setOrderId(long orderId) {
        this.orderId = orderId;
    }

    public List<Hamburger> getHamburgerList() {
        return hamburgerList;
    }

    public void setHamburgerList(List<Hamburger> hamburgerList) {
        this.hamburgerList = hamburgerList;
    }

    public CookingType getCookingType() {
        return cookingType;
    }

    public void setCookingType(CookingType cookingType) {
        this.cookingType = cookingType;
    }

    public OrderStatusType getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(OrderStatusType orderStatus) {
        this.orderStatus = orderStatus;
    }


    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
