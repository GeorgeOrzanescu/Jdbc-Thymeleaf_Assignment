package com.assignment.SpringBootAssignment.models;

public class OrderDetails {
    int id;
    int productCode;
    int quantity;
    double priceEach;

    public OrderDetails() {
    }

    //GETTERS
    public int getId() {
        return id;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getPriceEach() {
        return priceEach;
    }

    public int getProductCode() {
        return productCode;
    }

    //SETTERS

    public void setId(int id) {
        this.id = id;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setPriceEach(double priceEach) {
        this.priceEach = priceEach;
    }

    public void setProductCode(int productCode) {
        this.productCode = productCode;
    }
}
