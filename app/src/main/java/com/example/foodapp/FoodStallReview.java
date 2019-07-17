package com.example.foodapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import java.util.ArrayList;

public class FoodStallReview extends AppCompatActivity {


    private  static final String TAG ="FoodStallReview";
    private ArrayList<String> mStallName = new ArrayList<>();
    private ArrayList<String> mStallReview = new ArrayList<>();
    private  ArrayList<String> mStallScore = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food_stall_review);
        Log.d(TAG,"onCreate: started.");

    }
    private void initRecyclerView(){
        Log.d(TAG, "initRecyclerView: init recyclerview.");
        RecyclerView recyclerView= findViewById(R.id.rv_reviewList);
        FoodStallReviewAdapter adapter = new FoodStallReviewAdapter(this,mStallName,mStallReview,mStallScore);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }
}
