package com.example.demo.dto;

import javax.persistence.Embeddable;

@Embeddable
public class AddressDTO {

    private String number;
    private String street;

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
}
