package com.example.demo.entity;

import com.example.demo.dto.OrderDTO;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Order extends OrderDTO {

    @Id
    public String getId() {
        return super.getId();
    }

}
