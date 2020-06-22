package com.codegym.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

public class Cart {

    private List<CartProduct> products;

    private int totalQuantity;

    private float totalPrice;



    public Cart() {
        products = new ArrayList<>();
        totalQuantity=0;
        totalPrice=0;
    }

    public List<CartProduct> getProduct() {
        return products;
    }

    public void setProduct(List<CartProduct> product) {
        this.products = product;
    }

    public int getTotalQuantity() {
        return totalQuantity;
    }

    public void setTotalQuantity(int totalQuantity) {
        this.totalQuantity = totalQuantity;
    }

    public float getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(float totalPrice) {
        this.totalPrice = totalPrice;
    }
}
