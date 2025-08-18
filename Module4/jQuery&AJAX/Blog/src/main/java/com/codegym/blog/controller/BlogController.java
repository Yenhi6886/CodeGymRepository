package com.codegym.blog.controller;

import com.codegym.blog.model.Blog;
import com.codegym.blog.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/blogs")
@CrossOrigin("*")
public class BlogController {

    @Autowired
    private BlogService blogService;

    @GetMapping
    public List<Blog> getBlogs(@RequestParam int page, @RequestParam int size) {
        return blogService.findAll(page, size);
    }

    @GetMapping("/search")
    public List<Blog> searchBlogs(@RequestParam String keyword) {
        return blogService.search(keyword);
    }
}
