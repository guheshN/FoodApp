package com.example.foodapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

public class StallRV extends AppCompatActivity {
    ArrayList<Stalls> stall_List = new ArrayList<>();
    ArrayList<Stalls> temp_List = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stall_rv);

        //hardcode stall data(FC only)
        Stalls s1 = new Stalls(0,0,"Fried Master Chicken","chickies",0.0);
        Stalls s2 = new Stalls(1,0,"Malay Stall","Nasi Lemak",0.0);
        Stalls s3 = new Stalls(2,0,"Waffles","Ice cream",0.0);
        Stalls s4 = new Stalls(3,0,"Canopy Coffee Club","Drinks and more",0.0);
        Stalls s5 = new Stalls(4,0,"Henry's Western","Good Foodie!!",0.0);
        Stalls s6 = new Stalls(5,0,"MiniWok","Oily Good",0.0);
        //add into Stall List
        stall_List.add(s1);
        stall_List.add(s2);
        stall_List.add(s3);
        stall_List.add(s4);
        stall_List.add(s5);
        stall_List.add(s6);

        Intent intent = getIntent();
        int position = Integer.parseInt(intent.getStringExtra("position"));

        for (Stalls s : stall_List) {
            if(s.getCourtID() == position){
                temp_List.add(s);
            }
        }
        //find recyclerview in layout
        RecyclerView stallView = findViewById(R.id.view_Stall);

        //set all layout with same size
        stallView.setHasFixedSize(true);

        //set LayoutManager
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        stallView.setLayoutManager(layoutManager);

        if(temp_List.size() == 0){
            Intent error = new Intent(StallRV.this,SorryNotAvailablePage.class);
            startActivity(error);
        }
        else{
            //set Adapter + add data into recycler view
            StallAdapter sadapter = new StallAdapter(StallRV.this,temp_List);
            stallView.setAdapter(sadapter);
        }


    }
}
