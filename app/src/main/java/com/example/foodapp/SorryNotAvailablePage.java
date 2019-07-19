package com.example.foodapp;

import android.annotation.SuppressLint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class SorryNotAvailablePage extends AppCompatActivity {

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sorry_not_available_page);
        TextView errorText = findViewById(R.id.txt_error);
        errorText.setText("Sorry This Page Is Not Available :( \n We Will Work On It Soon");
    }
}
