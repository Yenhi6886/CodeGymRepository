package com.codegym.blog.service;

import com.codegym.blog.model.Blog;

import java.util.List;
import java.util.Optional;

public interface IGenerateService<T> {
    Iterable<T> findAll();

    void save(T blog);

    Optional<T> findById(Long id);

    void remove(Long id);
}