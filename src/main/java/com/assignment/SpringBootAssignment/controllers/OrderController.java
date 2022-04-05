package com.assignment.SpringBootAssignment.controllers;

import com.assignment.SpringBootAssignment.ServiceLayer.OrderService;
import com.assignment.SpringBootAssignment.models.Order;
import com.assignment.SpringBootAssignment.models.OrderDetails;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping("/placeOrder")
public class OrderController {
    
    @Autowired
    OrderService orderService;

    @GetMapping("/{orderId}")
    public ModelAndView placeOrder(@PathVariable String orderId) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("viewsOrder/order-details");
        modelAndView.addObject("id", orderId);
        modelAndView.addObject("orderDetails", new OrderDetails());
        return modelAndView;
    }

    @PostMapping("/newOrderDetails")
    public ModelAndView newOrderDetails(@ModelAttribute OrderDetails orderDetails) {
        ModelAndView modelAndView = new ModelAndView();
        try {
            orderService.placeOrder(String.valueOf(orderDetails.getId()), orderDetails);
            modelAndView.setViewName("message");
            modelAndView.addObject("message", "Order placed successfully");
            return modelAndView;
        } catch (IllegalArgumentException e) {
            modelAndView.setViewName("message");
            modelAndView.addObject("message", "Order not placed + " + e.getMessage());
            return modelAndView;
        }
    }
    
    @GetMapping("/")
    public ModelAndView placeOrder() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("viewsOrder/newOrder");
        modelAndView.addObject("order", new Order());
        modelAndView.addObject("orderDetails", new OrderDetails());
        return modelAndView;
    }

    @PostMapping("/newOrderStatus")
    public ModelAndView newOrder(@ModelAttribute Order order,@ModelAttribute OrderDetails orderDetails) {
        ModelAndView modelAndView = new ModelAndView();
        try {
            orderService.placeOrder(order, orderDetails);
            modelAndView.setViewName("message");
            modelAndView.addObject("message", "Order placed successfully");
            return modelAndView;
        } catch (IllegalArgumentException e) {
            modelAndView.setViewName("message");
            modelAndView.addObject("message", "Order not placed " + e.getMessage());
            return modelAndView;
        }
     
    }

}
