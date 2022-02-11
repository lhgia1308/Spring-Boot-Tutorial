package com.tutorial.apidemo.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

@Entity
@Table(name = "Categories")
public class Category {
    @Id
    private int id;
    private String name;
    private String slug;
    private String icon;
    @Column(name = "parent_id")
    private int parentId;

    @Transient
    private List<Product> products = new ArrayList<Product>();
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "category")
    public List<Product> getProducts() {
        return products;
    }
    public void setProducts(List<Product> products) {
        this.products = products;
    }
    
    public Category() {
    }
    public Category(int id, String name, String slug, String icon, int parent_id) {
        this.id = id;
        this.name = name;
        this.slug = slug;
        this.icon = icon;
        this.parentId = parent_id;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getSlug() {
        return slug;
    }
    public void setSlug(String slug) {
        this.slug = slug;
    }
    public String getIcon() {
        return icon;
    }
    public void setIcon(String icon) {
        this.icon = icon;
    }
    public int getParentId() {
        return parentId;
    }
    public void setParentId(int parent_id) {
        this.parentId = parent_id;
    }
    
}
