package com.codegym.blog.service;

import com.codegym.blog.model.Blog;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class BlogService {
    private static final List<Blog> blogs = new ArrayList<>();

    static {
        for (long i = 1; i <= 50; i++) {
            blogs.add(new Blog(i, "Tiêu đề " + i, "Nội dung blog số " + i));
        }
    }

    public List<Blog> findAll(int page, int size) {
        int from = page * size;
        int to = Math.min(from + size, blogs.size());
        return blogs.subList(from, to);
    }

    public List<Blog> search(String keyword) {
        return blogs.stream()
                .filter(b -> b.getTitle().toLowerCase().contains(keyword.toLowerCase()))
                .collect(Collectors.toList());
    }
}
