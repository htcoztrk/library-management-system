package com.example.library.controller;

import com.example.library.dto.request.CategoryAddRequest;
import com.example.library.dto.request.CategoryRequest;
import com.example.library.dto.response.CategoryResponse;
import com.example.library.entity.Category;
import com.example.library.service.CategoryService;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.annotation.RequestScope;

@RestController
@RequestMapping("/category")
@RequestScope
@CrossOrigin

public class CategoryController {
    private CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @PostMapping()

    public CategoryResponse addCategory(@RequestBody CategoryAddRequest request) {
        return categoryService.add(request);

    }



    @PutMapping(value = "{identity}")
    public CategoryResponse updateCategory(@PathVariable Long identity, @RequestBody CategoryRequest request) {

        return categoryService.update(identity,request);
    }

    @DeleteMapping(value = "{id}")
    public Category delete(@PathVariable Long id) {
        return categoryService.deleteById(id);
    }
}
