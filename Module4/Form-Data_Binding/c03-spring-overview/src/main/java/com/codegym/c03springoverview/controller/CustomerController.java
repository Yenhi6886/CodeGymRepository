package com.codegym.c03springoverview.controller;

import com.codegym.c03springoverview.model.Customer;
import com.codegym.c03springoverview.model.CustomerForm;
import com.codegym.c03springoverview.service.CustomerService;
import com.codegym.c03springoverview.service.ICustomerService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping("/customers")
public class CustomerController {

    @Value("${file-upload}")
    private String fileUpload;


    private final ICustomerService customerService = new CustomerService();

    @GetMapping("")
    public String index(Model model) {
        List<Customer> customerList = customerService.findAll();
        model.addAttribute("customers", customerList);
        return "/index";
    }

    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("customerForm", new CustomerForm());
        return "/create";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute CustomerForm customerForm) throws IOException {

        MultipartFile multipartFile = customerForm.getImage();
        String fileName = multipartFile.getOriginalFilename();
        try {
            FileCopyUtils.copy(customerForm.getImage().getBytes(), new File(fileUpload + fileName));
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        Customer customer = new Customer(customerForm.getId(), customerForm.getName(),
                customerForm.getEmail(),customerForm.getAddress(), fileName);
        customerService.save(customer);

        return "redirect:/customer";
    }
}