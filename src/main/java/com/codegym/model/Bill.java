package com.codegym.model;

public class Bill {

    private int totalQuantity;

    private float totalPrice;

    public Bill() {
    }

    public Bill(int totalQuantity, float totalPrice) {
        this.totalQuantity = totalQuantity;
        this.totalPrice = totalPrice;
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