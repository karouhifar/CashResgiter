package com.example.assignment_2;
import android.app.Application;
import java.util.ArrayList;


public class MyApp extends Application {
    ArrayList<Product>  productArrayList = new ArrayList<>();
    ArrayList<Purchase> purchase = new ArrayList<>(0);

    public MyApp() {
        productArrayList.add(new Product("Pante",20.44,10));
        productArrayList.add(new Product("Shoes",10.44,100));
        productArrayList.add(new Product("Hats",5.9,30));
    }

}
