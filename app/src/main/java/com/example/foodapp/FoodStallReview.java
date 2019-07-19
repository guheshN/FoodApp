package com.example.foodapp;

import android.content.Intent;
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
    private  static final String TAG ="FoodStallReview";
    ArrayList<Review> review_List = new ArrayList<>();
    ArrayList<Review> temp_List = new ArrayList<>();
    TextView name ;
    TextView des;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food_stall_review);
        Log.d(TAG,"onCreate: started.");

        //get information from StallRV activity
        Intent intent = getIntent();
        String stall_name = intent.getStringExtra("name");
        String stall_des = intent.getStringExtra("des");
        int position = Integer.parseInt(intent.getStringExtra("position"));

        //set TV variable to TV in layout
        name = findViewById(R.id.tv_StallName);
        des = findViewById(R.id.tv_StallDes);

        //hardcode data
        Review f1 = new Review(0,0,0,"Awesome","10");
        Review f2 = new Review(1,0,1 ,"Sedap","5");
        Review f3 = new Review(2,1,2,"Best","9");
        Review f4 = new Review(3,2,3,"Some Delicious Chicken","10");
        //add into list
        review_List.add(f1);
        review_List.add(f2);
        review_List.add(f3);
        review_List.add(f4);

        //Set the right text for TV in layout
        name.setText(stall_name);
        des.setText(stall_des);

        //get the right reviews for the rv
        for (Review r : review_List) {
            if(r.getStallID() == position){
                temp_List.add(r);
            }
        }

        //find recyclerview in layout
        RecyclerView FoodstallReviews = findViewById(R.id.rv_reviewList);

        //set all layout with same size
        FoodstallReviews.setHasFixedSize(true);

        //set LayoutManager
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        FoodstallReviews.setLayoutManager(layoutManager);

        //set Adapter + add data into recycler view
        FoodStallReviewAdapter fadapter = new FoodStallReviewAdapter(FoodStallReview.this,temp_List);
        FoodstallReviews.setAdapter(fadapter);

        //set button to bring to add review activity
        Button post_review_btn = findViewById(R.id.btn_PostReview);
        post_review_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent postreview = new Intent(FoodStallReview.this,Main3Activity.class);
                startActivity(postreview);
            }
        });



    }


}
