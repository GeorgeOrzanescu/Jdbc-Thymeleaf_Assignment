package com.assignment.SpringBootAssignment.datalayer;
import com.assignment.SpringBootAssignment.models.Product;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ProductRowMapper implements RowMapper<Product> {

    @Override
    public Product mapRow(ResultSet rs, int rowNum) throws SQLException {
        Product product = new Product();
        product.setCode(rs.getString("code"));
        product.setName(rs.getString("name"));
        product.setDescription(rs.getString("description"));
        product.setStock(rs.getString("stock"));
        product.setPrice(rs.getString("price"));
        return product;
    }
}
    
