package com.tutorial.apidemo.entities;

import javax.persistence.*;

import java.util.Calendar;
import java.util.Objects;

//POJO = Plain Object Java Object
@Entity
@Table(name="products")
public class Product {
    //this is "primary key"
    // @Id
    //@GeneratedValue(strategy = GenerationType.AUTO) //auto-increment
    //you can also use "sequence"
    // @SequenceGenerator(
    //         name = "product_sequence",
    //         sequenceName = "product_sequence",
    //         allocationSize = 1 //increment by 1
    // )
    // @GeneratedValue(
    //         strategy = GenerationType.SEQUENCE,
    //         generator = "product_sequence"
    // )
    @Id
    private int id;
    //validate = constraint
    @Column(name = "name", nullable = false, unique = true, length = 300)
    private String productName;
    private int year;
    private Double price;
    private String url;
    @Column(name = "category_id")
    private int categoryId;

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    @Transient
    private Category category;
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "categoryid", nullable = false)
    public Category getCategory() {
        return category;
    }
    public void setCategory(Category category) {
        this.category = category;
    }

    @Transient
    private int age;//age is calculated from "year"
    public int getAge() {
        return Calendar.getInstance().get(Calendar.YEAR) - year;
    }

    public Product(int id, String productName, int year, Double price, String url, int categoryId,
            Category category) {
        this.id = id;
        this.productName = productName;
        this.year = year;
        this.price = price;
        this.url = url;
        this.categoryId = categoryId;
    }

    //default constructor
    public Product() {}
    //calculated field = transient, not exist in MySql

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", productName='" + productName + '\'' +
                ", year=" + year +
                ", price=" + price +
                ", url='" + url + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return year == product.year
                && age == product.age && Objects.equals(id, product.id)
                && Objects.equals(productName, product.productName) &&
                Objects.equals(price, product.price) && Objects.equals(url, product.url);
    }


    @Override
    public int hashCode() {
        return Objects.hash(id, productName, year, price, url, age);
    }
}
