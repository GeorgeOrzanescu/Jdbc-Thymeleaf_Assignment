package com.assignment.SpringBootAssignment.datalayer;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.assignment.SpringBootAssignment.models.Customer;

import org.springframework.jdbc.core.RowMapper;

public class CustomerRowMapper implements RowMapper<Customer>{

    @Override
    public Customer mapRow(ResultSet rs, int rowNum) throws SQLException {
        Customer customer = new Customer();
        customer.setId(String.valueOf(rs.getInt("id")));
        customer.setUserName(rs.getString("username"));
        customer.setLastName(rs.getString("last_name"));
        customer.setFirstName(rs.getString("first_name"));
        customer.setPhone(rs.getString("phone"));
        customer.setAddress(rs.getString("address"));
        customer.setCity(rs.getString("city"));
        customer.setPostalCode(rs.getString("postalCode"));
        customer.setCountry(rs.getString("country"));
        return customer;
    }
    
}
