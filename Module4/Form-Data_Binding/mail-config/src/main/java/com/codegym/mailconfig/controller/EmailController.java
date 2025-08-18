package com.codegym.mailconfig.controller;


import com.codegym.mailconfig.model.EmailConfig;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Arrays;


@Controller
public class EmailController {

    @GetMapping("/config")
    public String showForm(Model model) {
        EmailConfig config = new EmailConfig("English", 25, false, "Thor\nKing, Asgard");
        model.addAttribute("emailConfig", config);
        model.addAttribute("languages", Arrays.asList("English", "Vietnamese", "Japanese", "Chinese"));
        model.addAttribute("pageSizes", Arrays.asList(5, 10, 15, 25, 50, 100));
        return "config";
    }

    @PostMapping("/config")
    public String update(@ModelAttribute EmailConfig emailConfig, Model model) {
        // Debug logging
        System.out.println("Received EmailConfig:");
        System.out.println("Language: " + emailConfig.getLanguage());
        System.out.println("Page Size: " + emailConfig.getPageSize());
        System.out.println("Spams Filter: " + emailConfig.isSpamsFilter());
        System.out.println("Signature: " + emailConfig.getSignature());

        model.addAttribute("emailConfig", emailConfig);
        return "result";
    }

}
