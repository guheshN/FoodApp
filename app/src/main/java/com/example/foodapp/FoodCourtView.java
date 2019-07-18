package com.example.foodapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

public class FoodCourtView extends AppCompatActivity {
    ArrayList<Court> court_List = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food_court_view);
        //hardcode data
        Court c1 = new Court(R.drawable.fc,"FoodClub");
        Court c2 = new Court(R.drawable.munch,"Munch");
        Court c3 = new Court(R.drawable.makanplace,"MakanPlace");
        Court c4 = new Court(R.drawable.poolside,"PoolSide");
        //add into list
        court_List.add(c1);
        court_List.add(c2);
        court_List.add(c3);
        court_List.add(c4);

        //find recyclerview in layout
        RecyclerView courtView = findViewById(R.id.view_Court);

        //set all layout with same size
        courtView.setHasFixedSize(true);

        //set LayoutManager
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        courtView.setLayoutManager(layoutManager);

        //set Adapter + add data into recycler view
        CourtAdapter cadapter = new CourtAdapter(FoodCourtView.this,court_List);
        courtView.setAdapter(cadapter);





    }
}