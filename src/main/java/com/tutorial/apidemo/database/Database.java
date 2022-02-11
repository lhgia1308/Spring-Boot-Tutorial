package com.tutorial.apidemo.database;

import java.util.Arrays;
import java.util.List;

import com.tutorial.apidemo.entities.Category;
import com.tutorial.apidemo.repositories.CategoryRepository;
import com.tutorial.apidemo.repositories.ProductRepository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
//Now connect with mysql using JPA
/*
***For MacOS
docker run -d --rm --name mysql-spring-boot-tutorial \
-e MYSQL_ROOT_PASSWORD=123456 \
-e MYSQL_USER=lhgia1308 \
-e MYSQL_PASSWORD=123456 \
-e MYSQL_DATABASE=test_db \
-p 3309:3306 \
--volume mysql-spring-boot-tutorial-volume:/var/lib/mysql \
mysql:latest
***For window
docker run -d --name mysql-spring-boot-tutorial -e MYSQL_ROOT_PASSWORD=123456 -e MYSQL_USER=lhgia1308 -e MYSQL_PASSWORD=123456 -e MYSQL_DATABASE=test_db -p 3309:3306 -v D:/Docker/Container/MySQL:/var/lib/mysql mysql:latest

mysql -h localhost -P 3309 --protocol=tcp -u lhgia1308 -p

* */
@Configuration
public class Database {
    //logger
    private static final Logger logger = LoggerFactory.getLogger(Database.class);
    @Bean
    CommandLineRunner initDatabase(CategoryRepository categoryRepository, ProductRepository productRepository) {
        // return new CommandLineRunner() {
        //     @Override
        //     public void run(String... args) throws Exception {
        //     //    Product productA = new Product("MacBook Pro 15", 2020,2200.0, "");
        //     //    Product productB = new Product("iPad Air Green", 2021,599.0,"");
        //     //    logger.info("insert data: "+productRepository.save(productA));
        //     //    logger.info("insert data: "+productRepository.save(productB));
        //     }
        // };
        
        return (args) -> {
            // Insert category
            // int newCateId = categoryRepository.getMaxId().isPresent() ? categoryRepository.getMaxId().get() + 1 : 1;
            // Category category = new Category();
            // category.setId(newCateId);
            // category.setName("Điện thoại, máy tính");
            // categoryRepository.save(category);
            // //Insert products
            // int newProductId = productRepository.getMaxId().isPresent() ? productRepository.getMaxId().get() + 1 : 1;
            // // Product productA = new Product(newProductId++, "MacBook Pro 15", 2020,2200.0, "");
            // // Product productB = new Product(newProductId++, "iPad Air Green", 2021,599.0,"");
            // // List.of(productA, productB);
            // Product productA = new Product();
            // productA.setId(newProductId++);
            // productA.setCategoryId(newCateId);
            // productA.setPrice(2200.0);
            // productA.setProductName("MacBook Pro 15");
            // productA.setYear(2020);
            // Product productB = new Product();
            // productB.setId(newProductId++);
            // productB.setCategoryId(newCateId);
            // productB.setPrice(599.0);
            // productB.setProductName("iPad Air Green");
            // productB.setYear(2021);
            // productRepository.saveAll(Arrays.asList(productA, productB));

            // List<Category> prodList = categoryRepository.findAll();
            // System.out.println(prodList);
        };
    }
}
