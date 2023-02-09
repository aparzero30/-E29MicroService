package com.example.cart.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
@jakarta.persistence.Entity
@Table(name = "productTable")
public class Product {
    @jakarta.persistence.GeneratedValue

    @jakarta.persistence.Id
    private Integer productId;
    private String productName;
    private float price;
    private int quantity;

    private int userId ;
    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public Long getProductId() {
        return Long.parseLong(String.valueOf(productId));
    }


    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductName() {
        return productName;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public float getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }
}
