package com.example.blog.service;

import com.example.blog.model.Category;

import java.util.Collection;

public interface CategoryService {
    Category getCategoryById(Long id);
    Category saveCategory(Category category);
    void deleteCategory(Category category);
    Collection<Category> getAllCategory();
}
