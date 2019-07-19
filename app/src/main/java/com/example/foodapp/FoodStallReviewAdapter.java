package com.example.foodapp;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.ArrayList;

public class FoodStallReviewAdapter extends RecyclerView.Adapter<FoodStallReviewAdapter.ReviewViewHolder>{
    private static final String TAG ="FoodStallReviewAdapter";

    private ArrayList<FoodstallReviews> foodstalllist;
    private Context context;

    public FoodStallReviewAdapter(Context f, ArrayList<FoodstallReviews> fList) {
        foodstalllist = fList;
        context = f;
    }

    @Override
    public ReviewViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v =LayoutInflater.from(context).inflate(R.layout.review_layout, viewGroup,false);
        ReviewViewHolder holder= new ReviewViewHolder(v);

        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ReviewViewHolder holder, int i) {
        Log.d(TAG,"onBindViewHolder: Called.");

        holder.stallName.setText(foodstalllist.get(i).getcStallName());
        holder.stallReview.setText(foodstalllist.get(i).getcStallReview());
        holder.stallScore.setText(foodstalllist.get(i).getcStallScore());



    }

    @Override
    public int getItemCount() {
        return foodstalllist.size();
    }

    public class ReviewViewHolder extends RecyclerView.ViewHolder{

        TextView stallName;
        TextView stallReview;
        TextView stallScore;
        public ReviewViewHolder( View itemView) {
            super(itemView);
            stallName= itemView.findViewById(R.id.tv_Name);
            stallReview = itemView.findViewById(R.id.tv_Review);
            stallScore = itemView.findViewById(R.id.tv_Score);
        }
    }

}


