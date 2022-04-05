package com.assignment.SpringBootAssignment.controllers;

import com.assignment.SpringBootAssignment.datalayer.CustomerManager;
import com.assignment.SpringBootAssignment.models.Customer;

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
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    public CustomerManager customerManagerDb;

    @GetMapping("/get/{id}")
    public ModelAndView getCustomerById(@PathVariable String id) {
        String messageFailed = "Customer with id " + id + " was not found";
        ModelAndView modelAndView = new ModelAndView();
        try {
            modelAndView.setViewName("viewsCustomer/customer");
            modelAndView.addObject("customer", customerManagerDb.getCustomerById(id));
            return modelAndView;
        } catch (Exception e) {
            modelAndView.setViewName("message");
            modelAndView.addObject("message", messageFailed);
            return modelAndView;
        }
    }

    @DeleteMapping("/del/{id}")
    public ModelAndView deleteCustomer(@PathVariable String id) {
        String messageSuccess = "Customer with id " + id + " deleted successfully";
        String messageFailed = "Customer with id " + id + " does not exist in the database";
        ModelAndView modelAndView = new ModelAndView();
        try {
            Customer customer = customerManagerDb.getCustomerById(id);
            customerManagerDb.deleteCustomer(id);
            modelAndView.setViewName("viewsCustomer/customer");
            modelAndView.addObject("customer", customer);
            modelAndView.addObject("message", messageSuccess);
            return modelAndView;
        } catch (Exception e) {
            modelAndView.setViewName("message");
            modelAndView.addObject("message", messageFailed);
            return modelAndView;
        }
    }

    @GetMapping("/add")
    public ModelAndView addCustomer() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("viewsCustomer/add-customer");
        modelAndView.addObject("customer", new Customer());
        return modelAndView;
    }

    @PostMapping("/addedCustomer")
    public ModelAndView addCustomer(@ModelAttribute Customer customer) {
        String messageSuccess = "Customer added successfully";
        ModelAndView modelAndView = new ModelAndView();
        try {
            customerManagerDb.insertCustomer(customer);
            modelAndView.setViewName("viewsCustomer/customer");
            modelAndView.addObject("customer", customer);
            modelAndView.addObject("message", messageSuccess);
            return modelAndView;
        } catch (Exception e) {
            modelAndView.setViewName("message");
            return modelAndView;
        }
    }

    @GetMapping("/get/byCity/{city}")
    public ModelAndView getCustomersByCity(@PathVariable String city) {
        String messageFailed = "No customers found in " + city;
        ModelAndView modelAndView = new ModelAndView();
        try {
            modelAndView.setViewName("viewsCustomer/customers-list");
            modelAndView.addObject("customers", customerManagerDb.getCustomersByCity(city));
            return modelAndView;
        } catch (Exception e) {
            modelAndView.setViewName("message");
            modelAndView.addObject("message", messageFailed);
            return modelAndView;
        }
    }

    @GetMapping("/updatePhone/{id}")
    public ModelAndView updatePhone(@PathVariable String id) {
        try {
            ModelAndView modelAndView = new ModelAndView();
            modelAndView.setViewName("viewsCustomer/update-phone");
            modelAndView.addObject("customer", customerManagerDb.getCustomerById(id));
            return modelAndView;
        } catch (Exception e) {
            return new ModelAndView("message");
        }
    }

    @PostMapping("/updatedPhone")
    public ModelAndView updatePhone(@ModelAttribute Customer customer) {
        String messageSuccess = "Phone number updated successfully";
        ModelAndView modelAndView = new ModelAndView();
        try {
            customerManagerDb.updateCustomerPhone(customer.getId(), customer.getPhone());
            modelAndView.setViewName("viewsCustomer/customer");
            modelAndView.addObject("customer", customer);
            modelAndView.addObject("message", messageSuccess);
            return modelAndView;
        } catch (Exception e) {
            modelAndView.setViewName("message");
            return modelAndView;
        }
    }
}

