package com.example.assignment_2;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class CustomPurchsaeAdapter  extends BaseAdapter {
    Context context;
    private final ArrayList<Purchase> purchaseList;
    private final LayoutInflater inflater;


    public CustomPurchsaeAdapter(Context context, ArrayList<Purchase> purchaseList) {
        this.context = context;
        this.purchaseList = purchaseList;
        inflater = (LayoutInflater.from(context));
    }

    @Override
    public int getCount() {
        return purchaseList.size();
    }

    @Override
    public Object getItem(int i) {
        return purchaseList.get(i);
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

        title.setText(purchaseList.get(i).getProductName());
        quantity.setText(String.valueOf(purchaseList.get(i).getPrice()));
        price.setText(String.valueOf(purchaseList.get(i).getQuantity()));
        return view;
    }


}
