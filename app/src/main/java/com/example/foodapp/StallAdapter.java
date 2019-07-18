package com.example.foodapp;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

public class StallAdapter extends RecyclerView.Adapter<StallAdapter.StallViewHolder>{
    //set Variables
    private ArrayList<Stalls> stall_List;
    private Context context;

    //Constructor
    public StallAdapter(Context c, ArrayList<Stalls> slist){
        context = c;
        stall_List = slist;
    }
    @NonNull
    @Override
    public StallViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(context).inflate(R.layout.foodstall_layout,viewGroup,false);
        StallAdapter.StallViewHolder svh = new StallAdapter.StallViewHolder(v);
        return svh;
    }

    @Override
    public void onBindViewHolder(@NonNull StallViewHolder holder, int i) {
        //set Text to textview
        holder.name.setText(stall_List.get(i).getStallName());
    }

    @Override
    public int getItemCount() {
        return stall_List.size();
    }

    public class StallViewHolder extends RecyclerView.ViewHolder{
        TextView name;
        public StallViewHolder(View itemview){
            super(itemview);
            //link Views to view in layout
            name = itemview.findViewById(R.id.tv_StallName);
        }

    }
}
