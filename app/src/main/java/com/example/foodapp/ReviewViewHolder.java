package com.example.foodapp;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

public class ReviewViewHolder extends RecyclerView.ViewHolder {
    public TextView name;
    public TextView review;
    public TextView Score;

    public ReviewViewHolder(View view){
        super(view);
        name = view.findViewById(android.R.id.text1);
        review = view.findViewById(android.R.id.text2);
        Score = view.findViewById(android.R.id.text7);
    }
}
