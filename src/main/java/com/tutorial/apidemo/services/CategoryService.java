package com.tutorial.apidemo.services;

import java.util.ArrayList;
import java.util.List;

import com.tutorial.apidemo.entities.Category;
import com.tutorial.apidemo.entities.Product;
import com.tutorial.apidemo.models.CategoryModel;
import com.tutorial.apidemo.models.ProductModel;
import com.tutorial.apidemo.repositories.CategoryRepository;
import com.tutorial.apidemo.repositories.ProductRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoryService implements ICategoryService{

    @Autowired
    CategoryRepository categoryRepository;
    @Autowired
    ProductRepository productRepository;

    public List<ProductModel> findProductsByCategory(int categoryId) {
        List<Product> products = productRepository.findProductsByCategory(categoryId);
        List<ProductModel> productModels = new ArrayList<ProductModel>();
        products.forEach((prod) -> {
            ProductModel model = new ProductModel();
            model.setId(prod.getId());
            model.setProductName(prod.getProductName());
            productModels.add(model);
        });
        return productModels;
    }

    @Override
    public List<CategoryModel> findByCategoryName(String name) {
        List<ProductModel> productModels = new ArrayList<ProductModel>();
        List<Object[]> products = categoryRepository.findProductsByCategoryName(name);
        products.forEach((prods) -> {
            System.out.println("prods id: " + prods[5]);
            System.out.println("prods name: " + prods[6]);
            ProductModel model = new ProductModel();
            model.setId((int) prods[5]);
            model.setProductName((String) prods[6]);
            productModels.add(model);
        });
        List<Category> categories = categoryRepository.findByName(name);
        List<CategoryModel> categoryModels = new ArrayList<CategoryModel>();
        categories.forEach((cate) -> {
            CategoryModel categoryModel = new CategoryModel();
            categoryModel.setId(cate.getId());
            categoryModel.setName(cate.getName());

            // List<ProductModel> products = new ArrayList<ProductModel>();
            // cate.getProducts().forEach((prod) -> {
            //     ProductModel productModel = new ProductModel();
            //     productModel.setId(prod.getId());
            //     productModel.setProductName(prod.getProductName());
            // });

            // List<Product> lst = cate.getProducts();
            // List<ProductModel> productModels = findProductsByCategory(cate.getId());

            categoryModel.setProdList(productModels);
            
            categoryModels.add(categoryModel);
        });
        return categoryModels;
    }
    
}
