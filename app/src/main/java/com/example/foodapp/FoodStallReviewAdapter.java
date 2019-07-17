package com.example.foodapp;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.constraint.ConstraintLayout;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class FoodStallReviewAdapter extends RecyclerView.Adapter<FoodStallReviewAdapter.ReviewViewHolder>{
    private static final String TAG ="FoodStallReviewAdapter";

    private ArrayList<String> mStallName = new ArrayList<>();
    private ArrayList<String> mStallReview = new ArrayList<>();
    private ArrayList<String> stallScore = new ArrayList<>();
    private Context mContext;

    public FoodStallReviewAdapter(Context Context, ArrayList<String> StallName, ArrayList<String> StallReview, ArrayList<String> stallScore) {
        this.mStallName = StallName;
        this.mStallReview = StallReview;
        this.stallScore = stallScore;
        this.mContext = Context;
    }

    @Override
    public ReviewViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        View view =LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.review_layout, viewGroup,false);
        ReviewViewHolder holder= new ReviewViewHolder(view);

        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ReviewViewHolder holder, int position) {
        Log.d(TAG,"onBindViewHolder: Called.");

        holder.stallName.setText(mStallName.get(position));



    }

    @Override
    public int getItemCount() {
        return mStallName.size();
    }

    public class ReviewViewHolder extends RecyclerView.ViewHolder{

        TextView stallName;
        TextView stallReview;
        TextView stallScore;
        RelativeLayout parentLayout;
        public ReviewViewHolder(@NonNull View itemView) {
            super(itemView);
            stallName= itemView.findViewById(R.id.tv_Name);
            stallReview = itemView.findViewById(R.id.tv_Review);
            stallScore = itemView.findViewById(R.id.tv_Score);
            parentLayout = itemView.findViewById(R.id.parent_layout);
        }
    }

}


