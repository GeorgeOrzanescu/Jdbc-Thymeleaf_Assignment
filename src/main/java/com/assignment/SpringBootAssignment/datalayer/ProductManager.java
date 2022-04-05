package com.assignment.SpringBootAssignment.datalayer;

import java.util.List;

import javax.sql.DataSource;

import com.assignment.SpringBootAssignment.models.Product;
import com.assignment.SpringBootAssignment.models.ProductOrder;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class ProductManager {
    JdbcTemplate template;

    @Autowired
    public ProductManager(DataSource dataSource) {
        template = new JdbcTemplate(dataSource);
    }

    public Product getProduct(String code) {
        String query = "select * from products where code = ?";
        return template.queryForObject(query, new ProductRowMapper(), code);
    }

    public List<Product> getAllProducts() {
        String query = "SELECT * FROM products";
        return template.query(query, new ProductRowMapper());
    }

    public void insertProduct(Product product) {
        String query = "INSERT INTO products (name, description, stock, price) VALUES (?, ?, ?, ?)";
        template.update(query, product.getName(), product.getDescription(), product.getStock(),
                product.getPrice());
    }
    
    public void deleteProduct(String code) {
        String query = "DELETE FROM products WHERE code = ?";
        template.update(query, code);
    }
    
    public void updateProduct(Product product, String code) {
        String query = "UPDATE products SET name = ?, description = ?, stock = ?, price = ? WHERE code = ?";
        template.update(query, product.getName(), product.getDescription(), product.getStock(),
                product.getPrice(), code);
    }

    public List<ProductOrder> getProductsAndOrders() {
        String query = "SELECT * FROM products JOIN orderDetails ON orderDetails.product_code = products.code";
        return template.query(query, new ProductOrderRowMapper());
    }
}
