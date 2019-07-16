package com.example.foodapp;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

public class FoodStallReviewAdapter  extends RecyclerView.Adapter<ReviewViewHolder> {
    private List<String> reviewList;
    public FoodStallReviewAdapter(List<String> sl) {

        this.reviewList = sl;
    }


    @Override
    public ReviewViewHolder onCreateViewHolder(ViewGroup parent, int viewType)
    {
        View item = LayoutInflater.from(parent.getContext())
                .inflate(android.R.layout.foodstallreview_layout, parent, false);

        return new ReviewViewHolder(item);
    }

    @Override
    public void onBindViewHolder(ReviewViewHolder holder, int position)
    {
        String s = reviewList.get(position);
         holder.name.setText(s);
    }

    @Override
    public int getItemCount()
    {
        return reviewList.size();
    }


    @Override
    public int getItemViewType(int position)
    {
        return 1;
    }

}