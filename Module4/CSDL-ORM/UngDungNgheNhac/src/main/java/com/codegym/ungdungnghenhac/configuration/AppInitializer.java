package com.codegym.ungdungnghenhac.configuration;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class AppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class[]{}; // Nếu không có cấu hình root
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class[]{AppConfiguration.class}; // Đây là config chứa @EnableWebMvc
    }

    @Override
    protected String[] getServletMappings() {
        return new String[]{"/"}; // ánh xạ tất cả request
    }
}
