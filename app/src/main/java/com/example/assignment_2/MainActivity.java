package com.example.assignment_2;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.NumberPicker;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Date;

public class MainActivity extends AppCompatActivity  {

    ArrayList<Product> productsArray;
    ListView productList;
    NumberPicker numberPicker;
    TextView productType;
    TextView quantityView;
    TextView totalPrice;
    Button BuyBtn;
    Button managerBtn;
    Product selectedProduct = new Product();
    Toast toast1;
    Toast toast2;
    Toast toast3;
    int qtyNum = 0;
    double totalPriceAmount = 0.0;
    AlertDialog.Builder builder;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        builder = new AlertDialog.Builder(this);
        numberPicker = findViewById(R.id.numberPicker);
        quantityView = findViewById(R.id.quantity);
        productList = findViewById(R.id.product_list);
        productType = findViewById(R.id.textView_1);
        totalPrice = findViewById(R.id.totalPrice);
        BuyBtn = findViewById(R.id.buyID);
        managerBtn = findViewById(R.id.managerID);

        productType.setText("");
        quantityView.setText("");
        BuyBtn.setOnClickListener(this::getresult);
        managerBtn.setOnClickListener(this::getmanager);

        productsArray = ((MyApp)getApplication()).productArrayList;


        CustomProductAdapter customProductAdapter = new CustomProductAdapter(this,productsArray);
        productList.setAdapter(customProductAdapter);


        if (numberPicker != null) {
            numberPicker.setMinValue(0);
            numberPicker.setMaxValue(100);
            numberPicker.setWrapSelectorWheel(true);
            numberPicker.setOnValueChangedListener((picker, oldVal, newVal) -> {
                qtyNum = newVal;

                if(productType.getText() == ""){
                    toastValidationProduct();
                }
                else if(selectedProduct.getQuantity() < newVal){
                    toastValidationQTY();
                }
                else {
                    if(toast1 != null)
                        toast1.cancel();
                    if(toast2 != null)
                        toast2.cancel();
                    quantityView.setText(String.valueOf(newVal));
                    getTotal(totalPrice);
                }

            });
        }



        productList.setOnItemClickListener((adapterView, view, i , l) -> {
            productType.setText(productsArray.get(i).getProductName());
            selectedProduct = productsArray.get(i);
            if(toast2 != null)
                toast2.cancel();
            if(selectedProduct.getQuantity() < qtyNum) {
                toastValidationQTY();
            }
            if (!quantityView.getText().toString().equals("") && selectedProduct.getQuantity() > qtyNum) {
                getTotal(totalPrice);
            }

        });

    }




    public void getTotal (TextView totalPriceView) {
        DecimalFormat formatter = new DecimalFormat("#0.00");
        totalPriceAmount = Double.parseDouble(formatter.format(qtyNum * selectedProduct.getPrice()));
        Log.d("total Price: ", String.valueOf(totalPriceAmount));
        totalPriceView.setText(String.valueOf(totalPriceAmount));
    }

    public void toastValidationQTY() {
        toast1 = Toast.makeText(this,"No Enough quantity in the stock!!!",Toast.LENGTH_LONG);
        totalPrice.setText("");
        toast1.show();
    }

    public void toastValidationProduct() {
        toast2 = Toast.makeText(this,"Not select product!!!",Toast.LENGTH_LONG);
        totalPrice.setText("");
        toast2.show();
    }

    public void getresult(View view) {



        if (selectedProduct == null || qtyNum == 0)
            Toast.makeText(this, "All fields are required!!!", Toast.LENGTH_LONG).show();
        else if(selectedProduct.getQuantity() < qtyNum)
        {
            toast1 = Toast.makeText(this,"No Enough quantity in the stock!!!",Toast.LENGTH_LONG);
            toast1.show();
        }
        else {
            Log.d("total Price purchased: ", String.valueOf(totalPriceAmount));
            selectedProduct.setQuantity(selectedProduct.getQuantity() - qtyNum);
            Purchase purchasedProduct = new Purchase(selectedProduct.getProductName(), totalPriceAmount , qtyNum, new Date());
            qtyNum= 0;
            numberPicker.setValue(0);
            quantityView.setText("");
            totalPrice.setText("");
            productType.setText("");
            selectedProduct = new Product();
            ((MyApp)getApplication()).purchase.add(purchasedProduct);
            CustomProductAdapter customProductAdapter = new CustomProductAdapter(this,productsArray);
            productList.setAdapter(customProductAdapter);


            builder.setTitle("Thank you for your purchase");
            String text = "Your purchase is " + String.valueOf(purchasedProduct.getQuantity()) + " " +
                    String.valueOf(purchasedProduct.getProductName()) + " for " + String.valueOf(purchasedProduct.getPrice());
            builder.setMessage(text);
            builder.setPositiveButton("Ok", null).setCancelable(true);
            builder.show();

        }
    }

    private void getmanager(View view) {
        Intent intent = new Intent(this, ManagerPanelActivity.class);
        startActivity(intent);
    }

}