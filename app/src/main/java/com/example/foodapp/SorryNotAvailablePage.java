package com.example.foodapp;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class SorryNotAvailablePage extends AppCompatActivity {

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sorry_not_available_page);
        Intent intent = getIntent();
        final String userid = intent.getStringExtra("userid");
        TextView errorText = findViewById(R.id.txt_error);
        errorText.setText("Sorry This Page Is Not Available :( \n We Will Work On It Soon");

        Button return_page = findViewById(R.id.btn_BackToCourt);
        return_page.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent return_page = new Intent(SorryNotAvailablePage.this,CourtRV.class);
                return_page.putExtra("userid", userid);
                startActivity(return_page);
            }
        });
    }
}
