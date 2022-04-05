package com.assignment.SpringBootAssignment.datalayer;

import javax.sql.DataSource;

import com.assignment.SpringBootAssignment.models.Order;
import com.assignment.SpringBootAssignment.models.OrderDetails;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class OrderManager {
    public JdbcTemplate template;

    @Autowired
    public OrderManager(DataSource dataSource) {
        template = new JdbcTemplate(dataSource);
    }

    public void placeOrder(String orderId, OrderDetails orderDetails) {
        String query = "INSERT INTO orderdetails (id,product_code,quantity,priceEach) VALUES (?,?,?,?)";
        template.update(query, orderId, orderDetails.getProductCode(), orderDetails.getQuantity(),
                orderDetails.getPriceEach());

        String query1 = "UPDATE products SET stock = stock - ? WHERE code = ?";
        template.update(query1, orderDetails.getQuantity(), orderDetails.getProductCode());
    }
    
    public void placeOrder(Order order, OrderDetails orderDetails) {
        String query = "INSERT INTO orders (id,order_date,shipped_date,status,comments,customer_id) VALUES (?,?,?,?,?,?)";
        template.update(query, order.getId(), order.getOrderDate(), order.getShippedDate(), order.getStatus(),
                order.getComments(),
                order.getCustomerId());

        String query1 = "INSERT INTO orderdetails (id,product_code,quantity,priceEach) VALUES (?,?,?,?)";
        template.update(query1, order.getId(), orderDetails.getProductCode(), orderDetails.getQuantity(),
                orderDetails.getPriceEach());
    }
    
    public Order getOrder(String orderId) {
        String query = "SELECT * FROM orders WHERE id = ?";
        return template.queryForObject(query, new OrderRowMapper(), orderId);
    }
}
