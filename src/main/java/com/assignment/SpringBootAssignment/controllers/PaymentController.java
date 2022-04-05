package com.assignment.SpringBootAssignment.controllers;

import com.assignment.SpringBootAssignment.datalayer.PaymentManager;
import com.assignment.SpringBootAssignment.models.Payment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping("payment")
public class PaymentController {

    @Autowired
    public PaymentManager paymentManager;

    @GetMapping("/registerPayment")
    public ModelAndView registerPayment(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("viewsPayment/add-payment");
        modelAndView.addObject("payment",new Payment());
        return modelAndView;
    }

    @PostMapping("/paymentDone")
    public ModelAndView registerPayment(@ModelAttribute Payment payment){
        ModelAndView modelAndView = new ModelAndView();
        String messageSuccess = "Payment registered successfully";
        try {
            paymentManager.registerPayment(payment);
            modelAndView.setViewName("viewsPayment/payment");
            modelAndView.addObject("payment", payment);
            modelAndView.addObject("message", messageSuccess);
            return modelAndView;
        } catch (Exception e) {
            modelAndView.setViewName("message");
            return modelAndView;
        }
    }
}