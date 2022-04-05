package com.assignment.SpringBootAssignment.models;

public class Order {
    int id;
    String orderDate;
    String shippedDate;
    String status;
    String comments;
    int customerId;

    public Order() {
    }

    //GETTERS
    public int getId() {
        return id;
    }

    public String getOrderDate() {
        return orderDate;
    }

    public String getShippedDate() {
        return shippedDate;
    }

    public String getStatus() {
        return status;
    }

    public String getComments() {
        return comments;
    }

    public int getCustomerId() {
        return customerId;
    }

    //SETTERS

    public void setId(int id) {
        this.id = id;
    }

    public void setOrderDate(String orderDate) {
        this.orderDate = orderDate;
    }

    public void setShippedDate(String shippedDate) {
        this.shippedDate = shippedDate;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }
}
