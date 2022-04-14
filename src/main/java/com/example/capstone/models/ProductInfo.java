package com.example.capstone.models;

import com.example.capstone.entity.Album;

public class ProductInfo {
    private String code;
    private String name;
    private double price;

    public ProductInfo() {
    }

    public ProductInfo(Album product) {
        this.code = product.getCode();
        this.name = product.getName();
        this.price = product.getPrice();
    }

    // Using in JPA/Hibernate query
    public ProductInfo(String code, String name, double price) {
        this.code = code;
        this.name = name;
        this.price = price;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

}