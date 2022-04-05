package com.assignment.SpringBootAssignment.models;

public class Product {
    String code;
    String name;
    String description;
    String stock;
    String price;

    public Product() {
    }

    // GETTERS
    public String getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getStock() {
        return stock;
    }

    public String getPrice() {
        return price;
    }

    // SETTERS

    public void setCode(String code) {
        this.code = code;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setStock(String stock) {
        this.stock = stock;
    }

    public void setPrice(String price) {
        this.price = price;
    }
    
}
