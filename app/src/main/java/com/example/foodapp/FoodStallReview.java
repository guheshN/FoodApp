package com.example.foodapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import java.util.ArrayList;

public class FoodStallReview extends AppCompatActivity {


    private  static final String TAG ="FoodStallReview";
    ArrayList<FoodstallReviews> foodStall_List = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food_stall_review);
        Log.d(TAG,"onCreate: started.");

        //hardcode data
        FoodstallReviews f1 = new FoodstallReviews("Aniq","Awesome","10");
        FoodstallReviews f2 = new FoodstallReviews("Dicco" ,"Sedap","5");
        FoodstallReviews f3 = new FoodstallReviews("Raymond","Best","9");
        FoodstallReviews f4 = new FoodstallReviews("Black Guy","delicious","10");
        //add into list
        foodStall_List.add(f1);
        foodStall_List.add(f2);
        foodStall_List.add(f3);
        foodStall_List.add(f4);

        //find recyclerview in layout
        RecyclerView FoodstallReviews = findViewById(R.id.rv_reviewList);

        //set all layout with same size
        FoodstallReviews.setHasFixedSize(true);

        //set LayoutManager
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        FoodstallReviews.setLayoutManager(layoutManager);

        //set Adapter + add data into recycler view
        FoodStallReviewAdapter fadapter = new FoodStallReviewAdapter(FoodStallReview.this,foodStall_List);
        FoodstallReviews.setAdapter(fadapter);






    }


}
