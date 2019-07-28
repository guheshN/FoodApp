package com.np.foodapp;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PostReview extends AppCompatActivity {
    MyDBHandler dbHandler = new MyDBHandler(this,null,null,2);
    public static final String MyPREFERENCES = "MyPrefs" ;
    public static final String Userid = "userid";
    public static final String Courtposition = "courtposition";
    public static final String Stallposition = "stallposition";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post_review);
        Intent review = getIntent();

        // Get required information from sharedpreference
        SharedPreferences prefs = getSharedPreferences(MyPREFERENCES, MODE_PRIVATE);
        final int position = prefs.getInt(Stallposition,0);
        final int userid = prefs.getInt(Userid,0);

        //call Views in layout to activity
        final EditText et_Score = findViewById(R.id.txt_Score);
        final EditText et_Review = findViewById(R.id.txt_Review);
        Button post = findViewById(R.id.btn_Post);

        //set button to add review
        post.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Pattern patternscore;
                Matcher matchscore;
                String scoreTxt = et_Score.getText().toString();
                String reviewTxt = et_Review.getText().toString();
                final String SCORE_PATTERN = "^[0-9]{1,2}$";

                patternscore= Pattern.compile(SCORE_PATTERN);
                matchscore= patternscore.matcher(scoreTxt);

                if(matchscore.matches()){
                    if(tryParse(scoreTxt,-1) <= -1 || tryParse(scoreTxt,-1) >= 11){
                        Toast.makeText(getApplicationContext(),"Please enter a score of 0-10",Toast.LENGTH_SHORT).show();
                    }
                    else{
                        Review review1 = new Review(0,(position+1),userid,reviewTxt,scoreTxt,0);
                        dbHandler.addReview(review1);

                        Intent review_page = new Intent(PostReview.this,FoodStallReview.class);
                        review_page.putExtra("class","postreview");
                        startActivity(review_page);
                    }
                }
                else{
                    Toast.makeText(getApplicationContext(),"Please enter a score of 0-10",Toast.LENGTH_SHORT).show();
                }

            }
        });
    }

    public int tryParse(String value, int defaultVal) {
        try {
            return Integer.parseInt(value);
        } catch (NumberFormatException e) {
            return defaultVal;
        }
    }
}
