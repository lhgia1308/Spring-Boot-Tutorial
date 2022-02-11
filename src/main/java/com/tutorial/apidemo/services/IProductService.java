package com.tutorial.apidemo.services;

import java.util.List;
import java.util.Optional;

import com.tutorial.apidemo.entities.Product;
import com.tutorial.apidemo.models.ProductModel;

public interface IProductService {
    List<ProductModel> findProductsByCategory(int categoryId);
    List<ProductModel> findProductsByCategoryName(String name);
}
