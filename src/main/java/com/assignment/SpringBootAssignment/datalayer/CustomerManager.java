package com.assignment.SpringBootAssignment.datalayer;

import java.util.List;

import javax.sql.DataSource;

import com.assignment.SpringBootAssignment.models.Customer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class CustomerManager {
    JdbcTemplate template;

    @Autowired
    public CustomerManager(DataSource dataSource) {
        template = new JdbcTemplate(dataSource);
    }

    public Customer getCustomerById(String id) {
        String query = "SELECT * FROM customers WHERE id = ?";
        return template.queryForObject(query, new CustomerRowMapper(), id);
    }
    
    public void deleteCustomer(String id) {
        String query = "DELETE FROM customers WHERE id = ?";
        template.update(query, id);
    }

    public void insertCustomer(Customer customer) {
        String query = "INSERT INTO customers (username, last_name, first_name, phone, address, city, postalCode, country) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        template.update(query, customer.getUserName(), customer.getLastName(), customer.getFirstName(),
                customer.getPhone(), customer.getAddress(), customer.getCity(), customer.getPostalCode(),
                customer.getCountry());
    }
    
    public List<Customer> getCustomersByCity(String city) {
        String query = "SELECT * FROM customers WHERE city = ?";
        return template.query(query, new CustomerRowMapper(), city);
    }

    public void updateCustomerPhone(String id, String phone) {
        String query = "UPDATE customers SET phone = ? WHERE id = ?";
        template.update(query, phone, id);
    }
}
