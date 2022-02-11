package com.tutorial.apidemo.controllers;

import java.util.List;

import com.tutorial.apidemo.models.CategoryModel;
import com.tutorial.apidemo.services.ICategoryService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "api/v1/categories")
public class CategoryController {
    @Autowired
    ICategoryService categoryService;

    @PostMapping("/find")
    public List<CategoryModel> findByCategoryName(@RequestParam(name = "name") String name) {
        System.out.println("===============name=============: " + name);
        return categoryService.findByCategoryName(name);
    }
}
