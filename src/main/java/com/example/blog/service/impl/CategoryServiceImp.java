package com.example.blog.service.impl;

import com.example.blog.model.Category;
import com.example.blog.repository.CategoryRepository;
import com.example.blog.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class CategoryServiceImp implements CategoryService {
    private CategoryRepository categoryRepository;

    @Autowired
    public void CategoryServiceImp(CategoryRepository categoryRepository){
        this.categoryRepository = categoryRepository;
    }

    @Override
    public Category getCategoryById(Long id) {
        return categoryRepository.getById(id);
    }

    @Override
    public Category saveCategory(Category category) {
        return categoryRepository.save(category);
    }

    @Override
    public void deleteCategory(Category category) {
        categoryRepository.delete(category);
    }

    @Override
    public Collection<Category> getAllCategory() {
        return categoryRepository.findAll();
    }
}
