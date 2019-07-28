package com.np.foodapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import java.util.ArrayList;

public class CourtRV extends AppCompatActivity{
    MyDBHandler dbHandler = new MyDBHandler(this,null,null,2);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_court_rv);
        Intent intent = getIntent();
        String userid = intent.getStringExtra("userid");

        //get data
        ArrayList<Court> court_List = dbHandler.getCourt();

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

    public void courtRV(ArrayList<Court> clist, final String uid){
        //find recyclerview in layout
        RecyclerView courtstallView = findViewById(R.id.view_Stall);

        //set all layout with same size
        courtstallView.setHasFixedSize(true);

        //set LayoutManager
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        courtstallView.setLayoutManager(layoutManager);

        //set Adapter + add data into recycler view
        CourtAdapter cadapter = new CourtAdapter(CourtRV.this,clist);
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