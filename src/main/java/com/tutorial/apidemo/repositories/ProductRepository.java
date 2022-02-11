package com.tutorial.apidemo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

import com.tutorial.apidemo.entities.Product;

public interface ProductRepository extends JpaRepository<Product, Integer> {
    List<Product> findByProductName(String productName);
    @Query(value = "SELECT max(id) FROM products", nativeQuery = true)
    Optional<Integer> getMaxId();
    @Query(value = "FROM Product WHERE category_id = :categoryId")
    List<Product> findProductsByCategory(int categoryId);
    @Query(value = "SELECT d.id, d.productName, d.year, d.price, d.url, c.id, c.name FROM Category c, Product d WHERE c.id = d.categoryId and c.name like %:name%")
    List<Object[]> findProductsByCategoryName(@Param("name") String name);
}
