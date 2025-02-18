package com.mycompany.guiceapp.model;

import jakarta.inject.Inject;

public class Item {
    public Item(Integer id, Integer quantity, String name) {
        this.id = id;
        this.quantity = quantity;
        this.name = name;
    }

    private Integer id;
    private Integer quantity;
    private String name;

    @Inject
    public Item(){
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}