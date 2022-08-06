package com.eric.pojo;

public class Product {
    int price;
    int storage;

    public Product() {
    }

    public Product(int price, int storage) {
        this.price = price;
        this.storage = storage;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getStorage() {
        return storage;
    }

    public void setStorage(int storage) {
        this.storage = storage;
    }
}
