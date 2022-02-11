package com.tutorial.apidemo.models;

import java.util.List;

import com.tutorial.apidemo.entities.Product;

public class CategoryModel {
    private int id;
    private String name;
    private String slug;
    private String icon;
    private int parentId;
    private List<ProductModel> prodList;
    private int productId;
    private String productName;
    
    public CategoryModel(int id, String name, String slug, String icon, int parentId,
            int productId, String productName) {
        this.id = id;
        this.name = name;
        this.slug = slug;
        this.icon = icon;
        this.parentId = parentId;
        this.productId = productId;
        this.productName = productName;
    }
    public CategoryModel(){}
    public CategoryModel(int id, String name, String slug, String icon, int parentId, List<ProductModel> prodList) {
        this.id = id;
        this.name = name;
        this.slug = slug;
        this.icon = icon;
        this.parentId = parentId;
        this.prodList = prodList;
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
    public void setParentId(int parentId) {
        this.parentId = parentId;
    }
    public List<ProductModel> getProdList() {
        return prodList;
    }
    public void setProdList(List<ProductModel> prodList) {
        this.prodList = prodList;
    }
    
}
