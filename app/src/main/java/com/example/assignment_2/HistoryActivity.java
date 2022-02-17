package com.example.assignment_2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class HistoryActivity extends AppCompatActivity {
    ListView productList;
    ArrayList<Purchase> purchasedProducts;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history);

        productList = findViewById(R.id.purchased_list);
        purchasedProducts = ((MyApp)getApplication()).purchase;

        CustomPurchsaeAdapter customPurchsaeAdapter = new CustomPurchsaeAdapter(this, purchasedProducts);
        productList.setAdapter(customPurchsaeAdapter);
        productList.setOnItemClickListener((adapterView, view, i , l) -> {
            Intent intent = new Intent(this, DetailHistoryActivity.class);
            String str = "Product: " + purchasedProducts.get(i).getProductName() + "\n" +
                    "Price: " + purchasedProducts.get(i).getPrice() + "\n" +
                    "Purchase Date: "+ purchasedProducts.get(i).getDate();
            intent.putExtra("DetailHistoryInfo", str);
            startActivity(intent);
        });
        }

    }
