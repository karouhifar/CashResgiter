package com.example.assignment_2;

import java.util.Date;

public class Purchase {
    private String productName;
    private double price;
    private int quantity;
    private Date date;

    public Purchase() {
        this.productName= "";
        this.price=0;
        this.quantity=0;
        this.date = null;
    }

    public Purchase(String name, double price, int quantity , Date date) {
        this.productName = name;
        this.price = price;
        this.quantity = quantity;
        this.date = date;
    }


    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Date getDate() {
        return date;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getPrice() {
        return price;
    }

    public String getProductName() {
        return productName;
    }
}
