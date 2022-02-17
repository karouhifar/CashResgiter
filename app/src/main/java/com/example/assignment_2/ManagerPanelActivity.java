package com.example.assignment_2;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ManagerPanelActivity extends AppCompatActivity {
Button history;
Button restock;
Intent intent,intent2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manager_panel);
        history = findViewById(R.id.historyBtn);
        restock = findViewById(R.id.restockBtn);
        history.setOnClickListener(this::clickEvent);
        restock.setOnClickListener(this::clickEvent);
    }


    @SuppressLint("NonConstantResourceId")
    public void clickEvent(View view) {
        int id = view.getId();
        switch (id){
            case R.id.historyBtn:
                intent = new Intent(this, HistoryActivity.class);
                startActivity(intent);
                break;
            case R.id.restockBtn:
                intent2 = new Intent(this, RestockActivity.class);
                startActivity(intent2);
                break;

        }

    }
}