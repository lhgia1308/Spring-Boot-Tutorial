package com.tutorial.apidemo.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.tutorial.apidemo.entities.Product;
import com.tutorial.apidemo.models.CategoryModel;
import com.tutorial.apidemo.models.ProductModel;
import com.tutorial.apidemo.repositories.ProductRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService implements IProductService {

    @Autowired
    ProductRepository productRepository;

    @Override
    public List<ProductModel> findProductsByCategory(int categoryId) {
        // TODO Auto-generated method stub
        return null;
    }
    @Override
    public List<ProductModel> findProductsByCategoryName(String name) {
        List<Object[]> foundProducts = productRepository.findProductsByCategoryName(name);
        List<ProductModel> productModels = new ArrayList<ProductModel>();
        foundProducts.forEach((prod) -> {
            ProductModel model = new ProductModel();
            model.setId((int) prod[0]);
            model.setProductName((String) prod[1]);
            CategoryModel cateModel = new CategoryModel();
            cateModel.setId((int) prod[5]);
            cateModel.setName((String) prod[6]);
            model.setCategory(cateModel);
            productModels.add(model);
        });
        return productModels;
    }
    
}
