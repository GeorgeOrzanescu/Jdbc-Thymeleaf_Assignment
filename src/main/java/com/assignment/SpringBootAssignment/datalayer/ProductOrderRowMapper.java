package com.assignment.SpringBootAssignment.datalayer;

import java.sql.ResultSet;
import java.sql.SQLException;
import com.assignment.SpringBootAssignment.models.ProductOrder;

import org.springframework.jdbc.core.RowMapper;

public class ProductOrderRowMapper implements RowMapper<ProductOrder> {

    @Override
    public ProductOrder mapRow(ResultSet rs, int rowNum) throws SQLException {
        ProductOrder productOrder = new ProductOrder();
        productOrder.setCode(rs.getString("code"));
        productOrder.setName(rs.getString("name"));
        productOrder.setDescription(rs.getString("description"));
        productOrder.setStock(rs.getString("stock"));
        productOrder.setPrice(rs.getString("price"));
        productOrder.setId(rs.getInt("id"));
        productOrder.setProductCode(rs.getInt("product_code"));
        productOrder.setQuantity(rs.getInt("quantity"));
        productOrder.setPriceEach(rs.getDouble("priceEach"));

        return productOrder;
    }
}
    

