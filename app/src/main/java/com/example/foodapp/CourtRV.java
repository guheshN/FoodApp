package com.example.foodapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

public class CourtRV extends AppCompatActivity{
    ArrayList<Court> court_List = new ArrayList<>();
    ArrayList<Stalls> stall_List = new ArrayList<>();
    ArrayList<Stalls> temp_List = new ArrayList<>();
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