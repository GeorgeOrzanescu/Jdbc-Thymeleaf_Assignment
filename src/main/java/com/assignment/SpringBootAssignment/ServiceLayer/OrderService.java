package com.assignment.SpringBootAssignment.ServiceLayer;

import com.assignment.SpringBootAssignment.datalayer.OrderManager;
import com.assignment.SpringBootAssignment.models.Order;
import com.assignment.SpringBootAssignment.models.OrderDetails;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

@Service
public class OrderService {
    
    @Autowired
    OrderManager orderManager;

    public void placeOrder(String orderId, OrderDetails orderDetails) {
        Order result = new Order();
        try
        {
           result = orderManager.getOrder(orderId);  
        } 
        catch (EmptyResultDataAccessException e) 
        {
            result = null;
        }
        if (result != null) {
            orderManager.placeOrder(orderId, orderDetails);
        } else {
            throw new IllegalArgumentException("Order with id: " + orderId + " does not exists");
        }
    }

    public void placeOrder(Order order, OrderDetails orderDetails) {
        Order result = new Order();
        try
        {
           result = orderManager.getOrder(String.valueOf(order.getId()));  
        } 
        catch (EmptyResultDataAccessException e) 
        {
            result = null;
        }
        if (result == null) {
           orderDetails.setId(order.getId()); // set order id in order details 
           orderManager.placeOrder(order, orderDetails);
        } else {
            throw new IllegalArgumentException("Order with id: " + order.getId() + " already exists");
        }
    }
}
