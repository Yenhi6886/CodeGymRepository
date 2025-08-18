package vn.codegym.deployment.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("message", "Xin chào Spring MVC + Thymeleaf!");
        return "index"; // -> /WEB-INF/views/index.html
    }
}
