package com.np.foodapp;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import java.util.ArrayList;

public class CourtRV extends AppCompatActivity{
    MyDBHandler dbHandler = new MyDBHandler(this,null,null,2);
    SharedPreferences sharedPreferences;
    public static final String MyPREFERENCES = "MyPrefs" ;
    public static final String Userid = "userid";
    public static final String Courtposition = "courtposition";
    public static final String Stallposition = "stallposition";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_court_rv);
        Intent intent = getIntent();

        //get data
        ArrayList<Court> court_List = dbHandler.getCourt();

        //add to RV method
        courtRV(court_List);



        //set logout button
        Button return_btn = findViewById(R.id.btn_LogoOut);
        return_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Bring back to login page
                Intent return_intent = new Intent(CourtRV.this,MenuPage.class);
                startActivity(return_intent);
                finish();
            }
        });

    }

    public void courtRV(ArrayList<Court> clist){
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
                sharedPreferences = getSharedPreferences(MyPREFERENCES,MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putInt(Courtposition,position);
                editor.apply();

                intent.putExtra("class","courtrv");
                startActivity(intent);
            }
        });
    }



}