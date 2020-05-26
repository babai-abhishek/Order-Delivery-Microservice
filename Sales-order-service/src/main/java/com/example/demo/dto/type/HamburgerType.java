package com.example.demo.dto.type;

public enum HamburgerType {
    ANGUS("ANGUS"),SCOTTONA("SCOTTONA"),CHIANINA("CHIANINA"),KOBE("KOBE"),VITELLONE("VITELLONE");

    private String description;

    HamburgerType(String description){
        this.description=description;
    }

    public String getDescription() {
        return description;
    }
}
