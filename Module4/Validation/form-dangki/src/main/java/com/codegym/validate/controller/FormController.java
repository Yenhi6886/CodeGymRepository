package com.codegym.validate.controller;

import com.codegym.validate.model.User;
import com.codegym.validate.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
public class FormController {

    @Autowired
    private UserService userService;

    @GetMapping("/")
    public String showForm(Model model) {
        model.addAttribute("user", new User());
        return "index";
    }

    @PostMapping("/register")
    public String register(@Valid @ModelAttribute("user") User user,
                           BindingResult result,
                           Model model) {
        if (result.hasErrors()) {
            return "index";
        }
        userService.save(user);
        model.addAttribute("user", user);
        return "result";
    }
}
