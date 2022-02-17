package com.example.assignment_2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class DetailHistoryActivity extends AppCompatActivity {
    TextView detailHistory;
    String data = "";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_history);

        detailHistory = findViewById(R.id.detailHistory);

        if (savedInstanceState == null) {
            data = getIntent().getStringExtra("DetailHistoryInfo");
        } else {
            data = (String) savedInstanceState.getSerializable("DetailHistoryInfo");
        }
        detailHistory.setText(data);

    }
}