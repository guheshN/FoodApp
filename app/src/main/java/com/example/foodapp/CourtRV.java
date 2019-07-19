package com.example.foodapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

public class CourtRV extends AppCompatActivity{
    ArrayList<Court> court_List = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_court_rv);
        //hardcode court data
        Court c1 = new Court(R.drawable.fc,"FoodClub");
        Court c2 = new Court(R.drawable.munch,"Munch");
        Court c3 = new Court(R.drawable.makanplace,"MakanPlace");
        Court c4 = new Court(R.drawable.poolside,"PoolSide");
        //add into court list
        court_List.add(c1);
        court_List.add(c2);
        court_List.add(c3);
        court_List.add(c4);

        //find recyclerview in layout
        RecyclerView courtstallView = findViewById(R.id.view_Stall);

        //set all layout with same size
        courtstallView.setHasFixedSize(true);

        //set LayoutManager
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        courtstallView.setLayoutManager(layoutManager);

        //set Adapter + add data into recycler view
        CourtAdapter cadapter = new CourtAdapter(CourtRV.this,court_List);
        courtstallView.setAdapter(cadapter);

        //When rv is clicked
        cadapter.setOnItemClickListener(new CourtAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
                Intent intent = new Intent(CourtRV.this,StallRV.class);
                String pos = "" + position;
                intent.putExtra("position",pos);
                startActivity(intent);
            }
        });

    }

}