package com.example.foodapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;

import java.nio.BufferUnderflowException;
import java.util.ArrayList;

public class CourtRV extends AppCompatActivity{
    ArrayList<Court> court_List = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_court_rv);
        Intent intent = getIntent();
        String userid = intent.getStringExtra("userid");

        //get data method
        CodeData(court_List);
        //add to RV method
        courtRV(court_List, userid);



        //set logout button
        Button logout = findViewById(R.id.btn_LogoOut);
        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Bring back to login page
                Intent logout = new Intent(CourtRV.this,LoginActivity.class);
                logout.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(logout);
                finish();
            }
        });

    }

    public void CodeData(ArrayList<Court> clist ){
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
    }

    public void courtRV(ArrayList<Court> clist, final String uid){
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
                intent.putExtra("userid", uid);
                intent.putExtra("courtposition",pos);
                intent.putExtra("class","courtrv");
                startActivity(intent);
            }
        });
    }



}