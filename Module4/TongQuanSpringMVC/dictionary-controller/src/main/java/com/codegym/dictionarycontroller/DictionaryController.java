package com.codegym.dictionarycontroller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@Controller
public class DictionaryController {

    private static final Map<String, String> dictionary = new HashMap<>();

    static {
        dictionary.put("hello", "xin chào");
        dictionary.put("apple", "quả táo");
        dictionary.put("book", "quyển sách");
        dictionary.put("cat", "con mèo");
        dictionary.put("dog", "con chó");
    }

    @GetMapping("/")
    public String showForm() {
        return "index";
    }

    @PostMapping("/search")
    public String search(@RequestParam String word, Model model) {
        String result = dictionary.get(word.toLowerCase());
        if (result != null) {
            model.addAttribute("result", result);
        } else {
            model.addAttribute("result", "Không tìm thấy từ này.");
        }
        model.addAttribute("word", word);
        return "index";
    }
}
