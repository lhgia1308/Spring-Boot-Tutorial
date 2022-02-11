package com.tutorial.apidemo.repositories;

import java.util.List;
import java.util.Optional;

import com.tutorial.apidemo.entities.Category;
import com.tutorial.apidemo.entities.Product;
import com.tutorial.apidemo.models.CategoryModel;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository("categoryRepository")
public interface CategoryRepository extends JpaRepository<Category, Long>{
    @Query(value = "SELECT max(id) FROM categories", nativeQuery = true)
	Optional<Integer> getMaxId();
    
    @Query(value = "FROM Category WHERE name like %:name%")
    List<Category> findByName(@Param("name") String name);

    @Query(value = "SELECT c.id, c.name, c.slug, c.icon, c.parentId, d.id, d.productName FROM Category c, Product d WHERE c.id = d.categoryId and c.name like %:name%")
    List<Object[]> findProductsByCategoryName(@Param("name") String name);
    
}
