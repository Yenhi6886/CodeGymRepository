package com.codegym.healthdeclaration;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import java.util.List;

@Controller
public class HealthDeclarationController {

    @GetMapping("/declaration")
    public String showForm(Model model) {
        model.addAttribute("declaration", new HealthDeclaration());

        model.addAttribute("symptomList", List.of("Sốt", "Ho", "Khó thở", "Đau họng"));
        model.addAttribute("exposureList", List.of("Tiếp xúc người nghi nhiễm", "Đến nơi có dịch"));

        return "declaration";
    }

    @PostMapping("/declaration")
    public String submitForm(
            @Validated @ModelAttribute("declaration") HealthDeclaration declaration,
            BindingResult bindingResult, Model model) {
        model.addAttribute("symptomList", List.of("Sốt", "Ho", "Khó thở", "Đau họng"));
        model.addAttribute("exposureList", List.of("Tiếp xúc người nghi nhiễm", "Đến nơi có dịch"));

        if (bindingResult.hasErrors()) {
            return "declaration";
        }

        // Lưu thông tin vào DB nếu cần
        return "result"; // trang hiển thị kết quả
    }
}
