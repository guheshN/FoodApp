package com.np.foodapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class PostReview extends AppCompatActivity {
    MyDBHandler dbHandler = new MyDBHandler(this,null,null,2);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post_review);
        //get ID from previous activity
        Intent review = getIntent();
        final int userid = Integer.parseInt(review.getStringExtra("userid"));
        final int position = Integer.parseInt(review.getStringExtra("position"));
        final String cposition = review.getStringExtra("courtposition");

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

                Review review1 = new Review(0,(position+1),userid,reviewTxt,scoreTxt,0);
                dbHandler.addReview(review1);

                Intent review_page = new Intent(PostReview.this,FoodStallReview.class);
                review_page.putExtra("userid",Integer.toString(userid));
                review_page.putExtra("class","postreview");
                review_page.putExtra("position",Integer.toString(position));
                review_page.putExtra("courtposition",cposition);
                startActivity(review_page);



            }
        });




    }
}
