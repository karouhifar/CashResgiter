package com.example.assignment_2;

public class Product {

    private String productName;
    private double price;
    private int quantity;

    public Product() {
        this.productName= "";
        this.price=0;
        this.quantity=0;
    }

    public Product(String name, double price, int quantity) {
        this.productName = name;
        this.price = price;
        this.quantity = quantity;
    }
    public String getProductName() {
        return productName;
    }

    public void setName(String productName) {
        this.productName = productName;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
