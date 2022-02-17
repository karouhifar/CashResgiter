package com.example.assignment_2;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class RestockActivity extends AppCompatActivity {

    ArrayList<Product> listProduct;
    ListView stock;
    Product ProductStocking;
    Button okButton;
    Button cancelButton;
    EditText newQty;
    CustomProductAdapter customProductAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_restock);
        listProduct = ((MyApp)getApplication()).productArrayList;
        customProductAdapter = new CustomProductAdapter(this,listProduct);
        stock = findViewById(R.id.stockList);
        okButton = findViewById(R.id.okButton);
        cancelButton = findViewById(R.id.cancelButton);
        newQty = findViewById(R.id.newQty);
        stock.setAdapter(customProductAdapter);


        okButton.setOnClickListener(this::EventClicked);
        cancelButton.setOnClickListener(this::EventClicked);

        stock.setOnItemClickListener((adapterView, view, i , l) -> {
            ProductStocking  = listProduct.get(i);
        });

    }

    @SuppressLint("NonConstantResourceId")
    public void EventClicked(View view){
       int ID = view.getId();

       switch (ID){

           case R.id.okButton:
               if (ProductStocking != null && !newQty.getText().toString().equals("")) {
                   Log.d("you are here: ", newQty.getText().toString());
                   ProductStocking.setQuantity(ProductStocking.getQuantity() + Integer.parseInt(newQty.getText().toString()));
                   customProductAdapter = new CustomProductAdapter(this,listProduct);
                   stock.setAdapter(customProductAdapter);
               }
               else
                   Toast.makeText(this,"All fields are REQUIRED", Toast.LENGTH_LONG).show();
               break;
           case R.id.cancelButton:
               Intent intent = new Intent(this,ManagerPanelActivity.class);
               startActivity(intent);
               break;

       }

    }
}