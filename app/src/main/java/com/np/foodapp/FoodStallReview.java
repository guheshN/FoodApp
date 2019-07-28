package com.np.foodapp;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

public class FoodStallReview extends AppCompatActivity {
    private  static final String TAG ="FoodStallReview.java";
    MyDBHandler dbHandler = new MyDBHandler(this,null,null,2);
    TextView name ;
    TextView des;
    public static final String MyPREFERENCES = "MyPrefs" ;
    public static final String Userid = "userid";
    public static final String Courtposition = "courtposition";
    public static final String Stallposition = "stallposition";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food_stall_review);
        Log.d(TAG,"onCreate: started.");
        // get information from intent
        final Intent intent = getIntent();
        //final String userid = intent.getStringExtra("userid");
        //final int position = Integer.parseInt(intent.getStringExtra("position"));
        //final String cposition = intent.getStringExtra("courtposition");

        SharedPreferences prefs = getSharedPreferences(MyPREFERENCES, MODE_PRIVATE);
        int position = prefs.getInt(Stallposition,0);

        //get the right stall to display information
        Stalls stall = getStall(position + 1);

        //get the correct reviews for the stall
        ArrayList<Review> review_list = getReview(position + 1);

        //get information of the stalls
        String stall_name = stall.getStallName();
        String stall_des = stall.getStallDes();

        //set information to layout
        setLayoutText(stall_name,stall_des);

        //set RV
        setAdapter(review_list);

        //Button for user to post
        PostReview();

        //create return button
        Button return_btn = findViewById(R.id.btn_return);
        return_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v ) {
                Intent return_stall = new Intent(FoodStallReview.this,StallRV.class);
                return_stall.putExtra("class","foodreview");
                //return_stall.putExtra("courtposition", cposition);
                //return_stall.putExtra("userid", userid);
                startActivity(return_stall);
            }
        });
    }
    public Stalls getStall(int position){
        Stalls stall = dbHandler.getStallDetail(position);
        return stall;
    }

    public ArrayList<Review> getReview(int position){
        ArrayList<Review> rlist = dbHandler.getReview(position);
        return rlist;
    }

    public void setLayoutText(String name,String des){
        //set TV variable to TV in layout
        this.name = findViewById(R.id.tv_StallName);
        this.des = findViewById(R.id.tv_StallDes);
        this.name.setText(name);
        this.des.setText(des);
    }

    public void setAdapter(ArrayList<Review> rlist){
        RecyclerView FoodstallReviews = findViewById(R.id.rv_reviewList);

        //set all layout with same size
        FoodstallReviews.setHasFixedSize(true);

        //set LayoutManager
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        FoodstallReviews.setLayoutManager(layoutManager);

        //set Adapter + add data into recycler view
        FoodStallReviewAdapter fadapter = new FoodStallReviewAdapter(FoodStallReview.this,rlist);
        FoodstallReviews.setAdapter(fadapter);
    }

    public void PostReview(){
        //set button to bring to add review activity
        final Button post_review_btn = findViewById(R.id.btn_PostReview);
        post_review_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent post_review = new Intent(FoodStallReview.this, PostReview.class);
                //pass information to next intent
                //post_review.putExtra("userid",uid);
               // post_review.putExtra("courtposition",cpos);
                //post_review.putExtra("position",Integer.toString(pos));
                startActivity(post_review);
            }
        });

    }


}
