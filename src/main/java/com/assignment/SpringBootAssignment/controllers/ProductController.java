package com.assignment.SpringBootAssignment.controllers;

import java.util.List;

import com.assignment.SpringBootAssignment.datalayer.ProductManager;
import com.assignment.SpringBootAssignment.models.Product;
import com.assignment.SpringBootAssignment.models.ProductOrder;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping("/product")
public class ProductController {
    @Autowired
    public ProductManager productManagerDb;

    @GetMapping("/getAll")
    public ModelAndView getAllProducts() {
        String messageFailed = "No products found";
        ModelAndView modelAndView = new ModelAndView();
        try {
            modelAndView.setViewName("viewsProduct/product-list");
            modelAndView.addObject("products", productManagerDb.getAllProducts());
        } catch (Exception e) {
            modelAndView.setViewName("message");
            modelAndView.addObject("message", messageFailed);
        }
        return modelAndView;
    }

    @GetMapping("/add")
    public ModelAndView addProduct() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("viewsProduct/add-product");
        modelAndView.addObject("product", new Product());
        return modelAndView;
    }

    @PostMapping("/addedProduct")
    public ModelAndView addedProduct(@ModelAttribute Product product) {
        String messageSuccess = "Product added successfully";
        ModelAndView modelAndView = new ModelAndView();
        try {
            productManagerDb.insertProduct(product);
            modelAndView.setViewName("viewsProduct/product");
            modelAndView.addObject("message", messageSuccess);
        } catch (Exception e) {
            modelAndView.setViewName("message");
        }
        return modelAndView;
        

    }
    @DeleteMapping("/del/{id}")
    public ModelAndView deleteProduct(@PathVariable String id) {
        String messageSuccess = "Product with code " + id + " deleted successfully";
        String messageFailed = "Product with code " + id + " does not exist in the database";
        ModelAndView modelAndView = new ModelAndView();
        try {
            Product product = productManagerDb.getProduct(id);
            productManagerDb.deleteProduct(id);
            modelAndView.setViewName("viewsProduct/product");
            modelAndView.addObject("product", product);
            modelAndView.addObject("message", messageSuccess);
            return modelAndView;
        } catch (Exception e) {
            modelAndView.setViewName("message");
            modelAndView.addObject("message", messageFailed);
            return modelAndView;
        }
    }

    @GetMapping("/update/{id}")
    public ModelAndView updateProduct(@PathVariable String id) {
        String messageFailed = "Product with code " + id + " does not exist in the database";
        ModelAndView modelAndView = new ModelAndView();
        try {
            Product product = productManagerDb.getProduct(id);
            modelAndView.setViewName("viewsProduct/update-product");
            modelAndView.addObject("product", product);
        } catch (Exception e) {
            modelAndView.setViewName("message");
            modelAndView.addObject("message", messageFailed);
        }
        return modelAndView;
    }

    @PostMapping("/updatedProduct")
    public ModelAndView updatedProduct(@ModelAttribute Product product) {
        String messageSuccess = "Product with code " + product.getCode() + " updated successfully";
        String messageFailed = "Product with code " + product.getCode() + " does not exist in the database";
        ModelAndView modelAndView = new ModelAndView();
        try {
            productManagerDb.updateProduct(product, product.getCode());
            modelAndView.setViewName("viewsProduct/product");
            modelAndView.addObject("product", product);
            modelAndView.addObject("message", messageSuccess);
        } catch (Exception e) {
            modelAndView.setViewName("message");
            modelAndView.addObject("message", messageFailed);
        }
        return modelAndView;
    }
    
    @GetMapping("/productOrders")
    public ModelAndView getProductOrders() {
        ModelAndView modelAndView = new ModelAndView();
        try {
            List<ProductOrder> products = productManagerDb.getProductsAndOrders();
            modelAndView.addObject("products", products);
            modelAndView.setViewName("viewsProduct/product-orders");    
        } catch (Exception e) {
            modelAndView.setViewName("message");
        }
        return modelAndView;
    }


}
