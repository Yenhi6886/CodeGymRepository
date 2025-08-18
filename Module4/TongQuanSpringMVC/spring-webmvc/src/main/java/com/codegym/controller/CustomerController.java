package com.codegym.controller;

import com.codegym.model.Customer;
import com.codegym.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @GetMapping("/customers")
    public ModelAndView showList() {
        List<Customer> customers = customerService.findAll();
        ModelAndView mav = new ModelAndView("customers/list.jsp");
        mav.addObject("customers", customers);
        return mav;
    }

    @GetMapping("/customer/info")
    public ModelAndView showDetail(@RequestParam("id") int id) {
        Customer customer = customerService.findById(id);
        ModelAndView mav = new ModelAndView("customers/info.jsp");
        mav.addObject("customer", customer);
        return mav;
    }
}
