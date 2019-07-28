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

public class StallRV extends AppCompatActivity {
    MyDBHandler dbHandler = new MyDBHandler(this,null,null,2);
    SharedPreferences sharedPreferences;
    public static final String MyPREFERENCES = "MyPrefs" ;
    public static final String Userid = "userid";
    public static final String Courtposition = "courtposition";
    public static final String Stallposition = "stallposition";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stall_rv);
        Intent intent = getIntent();
        //final String userid = intent.getStringExtra("userid");
        //final int position = Integer.parseInt(intent.getStringExtra("courtposition"));

        SharedPreferences prefs = getSharedPreferences(MyPREFERENCES, MODE_PRIVATE);
        int position = prefs.getInt(Courtposition,0);


        //get the right stalls for the right food court
        ArrayList<Stalls> stall_list = GetStalls(position);

        //set RV
        SetRecyclerView(stall_list,position);

        //set Return button
        Button return_page = findViewById(R.id.btn_return_page);
        return_page.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent return_intent = new Intent(StallRV.this,CourtRV.class);
                //return_intent.putExtra("userid",userid);
                startActivity(return_intent);
            }
        });
    }

    public void CodeData(ArrayList<Stalls> slist){
       /* //hardcode stall data(FC only)
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
        stall_List.add(s6);*/
    }

    public ArrayList<Stalls> GetStalls(int pos){

        ArrayList<Stalls> slist = dbHandler.getStall(pos);
        return slist;
    }

    public void SetRecyclerView(final ArrayList<Stalls> clist, final int cposition){
        //find recyclerview in layout
        RecyclerView stallView = findViewById(R.id.view_Stall);

        //set all layout with same size
        stallView.setHasFixedSize(true);

        //set LayoutManager
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        stallView.setLayoutManager(layoutManager);

        //set condition for food court that does not have information
        if(clist.size() == 0){
            //Bring them to error page
            Intent error = new Intent(StallRV.this,SorryNotAvailablePage.class);
            startActivity(error);
        }
        else{
            //set Adapter + add data into recycler view
            StallAdapter sadapter = new StallAdapter(StallRV.this,clist);
            stallView.setAdapter(sadapter);
            //when rv is clicked
            sadapter.setOnClickListener(new StallAdapter.OnItemClickListener() {
                @Override
                public void onItemClick(int position) {
                    //Bring to new intent with required information
                    Intent review_Intent = new Intent(StallRV.this, FoodStallReview.class);
                    sharedPreferences = getSharedPreferences(MyPREFERENCES,MODE_PRIVATE);
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putInt(Stallposition,position);
                    editor.apply();
                    //String pos = "" + position;
                    //bring info to intent
                    //review_Intent.putExtra("courtpostion",Integer.toString(cposition));
                    //review_Intent.putExtra("userid",uid);
                    //review_Intent.putExtra("position",pos);
                    review_Intent.putExtra("class","stall");
                    startActivity(review_Intent);
                }
            });
        }
    }
}
