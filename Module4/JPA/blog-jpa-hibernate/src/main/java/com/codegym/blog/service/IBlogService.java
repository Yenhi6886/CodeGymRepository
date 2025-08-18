package com.codegym.blog.service;

import com.codegym.blog.model.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IBlogService extends IGenerateService<Blog> {
    Page<Blog> findAll(Pageable pageable);

    Page<Blog> findByTitleContaining(String title, Pageable pageable);

    Page<Blog> findAllByCategoryId(Long categoryId, Pageable pageable);

}