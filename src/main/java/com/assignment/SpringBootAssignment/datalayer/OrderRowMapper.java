package com.assignment.SpringBootAssignment.datalayer;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.assignment.SpringBootAssignment.models.Order;

import org.springframework.jdbc.core.RowMapper;

public class OrderRowMapper implements RowMapper<Order> {

    @Override
    public Order mapRow(ResultSet rs, int rowNum) throws SQLException {
        Order order = new Order();
        order.setId(Integer.parseInt(rs.getString("id")));
        order.setOrderDate(rs.getString("order_date"));
        order.setShippedDate(rs.getString("shipped_date"));
        order.setStatus(rs.getString("status"));
        order.setComments(rs.getString("comments"));
        order.setCustomerId(Integer.parseInt(rs.getString("customer_id")));
        return order;
    }
    

}
