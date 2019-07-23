package com.np.foodapp;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

public class FoodStallReviewAdapter extends RecyclerView.Adapter<FoodStallReviewAdapter.ReviewViewHolder>{
    private static final String TAG ="FoodStallReviewAdapter";

    private ArrayList<Review> foodstalllist;
    private Context context;

    public FoodStallReviewAdapter(Context f, ArrayList<Review> fList) {
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

        //String user_id = Integer.toString(foodstalllist.get(i).getUserID());
        String anon = "Anonymous";
        String review = foodstalllist.get(i).getStallReview();
        String score = foodstalllist.get(i).getStallScore();
        holder.userID.setText(anon);
        holder.stallReview.setText(review);
        holder.stallScore.setText(score);



    }

    @Override
    public int getItemCount() {
        return foodstalllist.size();
    }

    public class ReviewViewHolder extends RecyclerView.ViewHolder{

        TextView userID;
        TextView stallReview;
        TextView stallScore;
        public ReviewViewHolder( View itemView) {
            super(itemView);
            userID= itemView.findViewById(R.id.tv_Name);
            stallReview = itemView.findViewById(R.id.tv_MyReview);
            stallScore = itemView.findViewById(R.id.tv_Score);
        }
    }

}


