package com.example.assignment_2;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class CustomProductAdapter extends BaseAdapter {
    Context context;
    private final ArrayList<Product> productList;
    private final LayoutInflater inflater;


    public CustomProductAdapter(Context context, ArrayList<Product> productList) {
        this.context = context;
        this.productList = productList;;
        inflater = (LayoutInflater.from(context));
    }

    @Override
    public int getCount() {
        return productList.size();
    }

    @Override
    public Object getItem(int i) {
        return productList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @SuppressLint("ViewHolder")
    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        view = inflater.inflate(R.layout.product_item,null);

        TextView title = (TextView) view.findViewById(R.id.product_list_title);
        TextView quantity = (TextView) view.findViewById(R.id.product_list_quantity);
        TextView price = (TextView) view.findViewById(R.id.product_list_price);

        title.setText(productList.get(i).getProductName());
        quantity.setText(String.valueOf(productList.get(i).getPrice()));
        price.setText(String.valueOf(productList.get(i).getQuantity()));
        return view;
    }
}
