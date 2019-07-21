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
    private  static final String TAG ="FoodStallReview.java";
    ArrayList<Review> review_List = new ArrayList<>();
    ArrayList<Review> temp_List = new ArrayList<>();
    TextView name ;
    TextView des;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food_stall_review);
        Log.d(TAG,"onCreate: started.");
        final Intent intent = getIntent();
        //check the intent is coming from which activity
        String check_activity = intent.getStringExtra("class");
        if(check_activity.equals("postreview")){
            //get information from PostReview activity
            //Review review = (Review) intent.getSerializableExtra(PostReview.serial_key);
            //Log.v(TAG,"Review:" + review.getStallReview() + "'" + review.getStallScore());
            //review_List.add(review);
            String review = intent.getStringExtra("review");
            String score = intent.getStringExtra("score");
            String userid = intent.getStringExtra("userid");
            final String court_position = intent.getStringExtra("courtposition");
            final String stall_name = intent.getStringExtra("name");
            final String stall_des = intent.getStringExtra("des");
            final int position = Integer.parseInt(intent.getStringExtra("position"));

            Review new_review = new Review(0,position,Integer.parseInt(userid),review,score);
            review_List.add(new_review);

            setLayoutText(stall_name,stall_des);
            setAdapter(position,review_List,temp_List);
            PostReview(position,stall_name,stall_des,court_position,userid);
        }
        else{
            //get information from StallRV activity
            String userid = intent.getStringExtra("userid");
            final String court_position = intent.getStringExtra("courtposition");
            final String stall_name = intent.getStringExtra("name");
            final String stall_des = intent.getStringExtra("des");
            final int position = Integer.parseInt(intent.getStringExtra("position"));

            setLayoutText(stall_name,stall_des);
            setAdapter(position,review_List,temp_List);
            PostReview(position,stall_name,stall_des,court_position,userid);
        }

        Button return_btn = findViewById(R.id.btn_return);
        return_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent return_stall = new Intent(FoodStallReview.this,StallRV.class);
                return_stall.putExtra("class","foodreview");
                return_stall.putExtra("courtposition",intent.getStringExtra("courtposition"));
                startActivity(return_stall);
            }
        });
    }

    public void setLayoutText(String name,String des){
        //set TV variable to TV in layout
        this.name = findViewById(R.id.tv_StallName);
        this.des = findViewById(R.id.tv_StallDes);
        this.name.setText(name);
        this.des.setText(des);
    }

    public void setAdapter(int position, ArrayList<Review> rlist , ArrayList<Review> tlist){
        //hardcode data
        Review f1 = new Review(0,0,0,"Awesome","10");
        Review f2 = new Review(1,0,1 ,"Sedap","5");
        Review f3 = new Review(2,1,2,"Best","9");
        Review f4 = new Review(3,2,3,"Some Delicious Chicken","10");
        //add into list
        rlist.add(f1);
        rlist.add(f2);
        rlist.add(f3);
        rlist.add(f4);


        //get the right reviews for the rv
        for (Review r : rlist) {
            if(r.getStallID() == position){
                tlist.add(r);
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
        FoodStallReviewAdapter fadapter = new FoodStallReviewAdapter(FoodStallReview.this,tlist);
        FoodstallReviews.setAdapter(fadapter);
    }

    public void PostReview(final int i, final String n, final String d, final String cp, final String uid){
        //set button to bring to add review activity
        final Button post_review_btn = findViewById(R.id.btn_PostReview);
        post_review_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent post_review = new Intent(FoodStallReview.this, PostReview.class);
                post_review.putExtra("userid",uid);
                post_review.putExtra("reviewid",Integer.toString(temp_List.size()));
                post_review.putExtra("courtposition",cp);
                post_review.putExtra("position",Integer.toString(i));
                post_review.putExtra("name",n);
                post_review.putExtra("des",d);
                startActivity(post_review);
            }
        });

    }


}
