package com.codegym.model;

public class CartProduct {

    private Long id;
    private String name;
    private String image;
    private float price;
    private String describes;
    private Category category;
    private Brand brand;
    private int quantity;

    public CartProduct() {
    }

    public CartProduct(Long id, String name, String image, float price, String describes, Category category, Brand brand, int quantity) {
        this.id = id;
        this.name = name;
        this.image = image;
        this.price = price;
        this.describes = describes;
        this.category = category;
        this.brand = brand;
        this.quantity = quantity;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getDescribes() {
        return describes;
    }

    public void setDescribes(String describes) {
        this.describes = describes;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Brand getBrand() {
        return brand;
    }

    public void setBrand(Brand brand) {
        this.brand = brand;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}