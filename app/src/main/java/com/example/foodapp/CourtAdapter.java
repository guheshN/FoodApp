package com.example.foodapp;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class CourtAdapter extends RecyclerView.Adapter<CourtAdapter.CourtViewHolder> {
    //set variables
    private ArrayList<Court> courtList;
    private Context context;

    //Constructor
    public CourtAdapter(Context c, ArrayList<Court> clist){
        courtList = clist;
        context = c;
    }

    @NonNull
    @Override
    public CourtViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(context).inflate(R.layout.foodcourt_layout,viewGroup,false);
        CourtViewHolder cvh = new CourtViewHolder(v);
        return cvh;

    }

    @Override
    public void onBindViewHolder(@NonNull CourtViewHolder holder, int i) {
        //set image to imageview
        holder.courtimage.setImageResource(courtList.get(i).getCimage());
        //set text to textview
        holder.name.setText(courtList.get(i).getCname());


    }

    @Override
    public int getItemCount() {
        return courtList.size();
    }

    public class CourtViewHolder extends RecyclerView.ViewHolder{
        ImageView courtimage;
        TextView name;
        public CourtViewHolder(View itemview){
            super(itemview);
            //link views to view in layout
            courtimage = itemview.findViewById(R.id.iv_Court);
            name = itemview.findViewById(R.id.tv_CourtName);
        }




    }
}
