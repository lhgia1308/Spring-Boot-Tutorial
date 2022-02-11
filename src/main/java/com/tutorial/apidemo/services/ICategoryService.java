package com.tutorial.apidemo.services;

import java.util.List;

import com.tutorial.apidemo.models.CategoryModel;

public interface ICategoryService {
    List<CategoryModel> findByCategoryName(String name);
}
