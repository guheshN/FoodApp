package com.example.foodapp;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

public class ReviewViewHolder extends RecyclerView.ViewHolder {
    public TextView name;
    public TextView review;
    public TextView score;

    public ReviewViewHolder(View view){
        super(view);
        name = view.findViewById(R.id.tv_Name);
        review = view.findViewById(R.id.tv_Review);
        score = view.findViewById(R.id.tv_Score);
    }
}
