package com.example.blog.controller;

import com.example.blog.model.Category;
import com.example.blog.service.CategoryService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/category")
@Slf4j
public class CategoryController {

    private CategoryService categoryService;

    @Autowired
    public void CategoryController(CategoryService categoryService){
        this.categoryService = categoryService;
    }

    @GetMapping
    public String listOfCategory(Model model){
        model.addAttribute("categories", categoryService.getAllCategory());
        return "categories-form";
    }

    @PostMapping
    public String listOfCategoryPost(Model model){
        model.addAttribute("categories", categoryService.getAllCategory());
        return "categories-form";
    }

    @GetMapping("/create")
    public String getCreateCategory(Category category){
        return "category-create";
    }

    @PostMapping("/create")
    public String postCreateCategory(Category category){
        categoryService.saveCategory(category);
        return "redirect:/category";
    }
}
