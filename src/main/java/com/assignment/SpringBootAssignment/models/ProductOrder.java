package com.assignment.SpringBootAssignment.models;

public class ProductOrder {
    String code;
    String name;
    String description;
    String stock;
    String price;

    int id;
    int productCode;
    int quantity;
    double priceEach;

    public ProductOrder() {
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

    public int getId() {
        return id;
    }

    public int getProductCode() {
        return productCode;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getPriceEach() {
        return priceEach;
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

    public void setId(int id) {
        this.id = id;
    }

    public void setProductCode(int productCode) {
        this.productCode = productCode;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setPriceEach(double priceEach) {
        this.priceEach = priceEach;
    }

}
