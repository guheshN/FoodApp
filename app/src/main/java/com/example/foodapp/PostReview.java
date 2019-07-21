package com.example.foodapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;

public class PostReview extends AppCompatActivity {
    private static final String TAG = "PostReview.java";
    public final static String serial_key = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post_review);
        //get ID from previous activity
        Intent review = getIntent();
        final int review_ID = Integer.parseInt(review.getStringExtra("reviewid"));
        final String court_position = review.getStringExtra("courtposition");
        final String stall_name = review.getStringExtra("name");
        final String stall_des = review.getStringExtra("des");
        final int position = Integer.parseInt(review.getStringExtra("position"));

        //call Views in layout to activity
        final EditText et_Score = findViewById(R.id.txt_Score);
        final EditText et_Review = findViewById(R.id.txt_Review);
        Button post = findViewById(R.id.btn_Post);

        //set button to add review
        post.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String scoreTxt = et_Score.getText().toString();
                String reviewTxt = et_Review.getText().toString();

                Review review1 = new Review(review_ID,position,1,reviewTxt,scoreTxt);
                Log.v(TAG,"Review:" + review1.getStallReview() + "'" + review1.getStallScore());

                Intent review_page = new Intent(PostReview.this,FoodStallReview.class);
                Bundle bundle = new Bundle();
                bundle.putSerializable(serial_key,review1);
                review_page.putExtras(bundle);
                review_page.putExtra("class","postreview");
                review_page.putExtra("courtposition",court_position);
                review_page.putExtra("position",Integer.toString(position));
                review_page.putExtra("name",stall_name);
                review_page.putExtra("des",stall_des);
                startActivity(review_page);



            }
        });




    }
}
