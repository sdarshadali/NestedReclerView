package com.nestedreclerview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class Parent_recyclerViewAdapter extends RecyclerView.Adapter<Parent_recyclerViewAdapter.MyViewHolder> {
    ArrayList<String> parentArrayList;
    Context context;



    public Parent_recyclerViewAdapter(ArrayList<String> parentArrayList, Context context) {
        this.parentArrayList = parentArrayList;
        this.context = context;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.parent_rowlayout,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.ItemName.setText(parentArrayList.get(position));
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(context,LinearLayoutManager.HORIZONTAL,false);
        holder.childRV.setLayoutManager(layoutManager);
        holder.childRV.setHasFixedSize(true);
        ArrayList<String> daysArrayList = new ArrayList<>();
        if (parentArrayList.get(position).equals("Item Two")){
            String[] days = {"Sat","Sun","Mon"};
            for (int i = 0; i < days.length;i++) {
                daysArrayList.add(days[1]);
            }
        }
        else {
            String[] days = {"Sat","Sun","Mon","Tue","Wed"};
            for (int i = 0; i < days.length;i++){
                daysArrayList.add(days[1]);

        }

        }
            ChildRecyclerAdapter childRecyclerAdapter = new ChildRecyclerAdapter(daysArrayList);
        holder.childRV.setAdapter(childRecyclerAdapter);
        childRecyclerAdapter.notifyDataSetChanged();


    }

    @Override
    public int getItemCount() {
        return parentArrayList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{

        TextView ItemName;
        RecyclerView childRV;


        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            ItemName = itemView.findViewById(R.id.itemname);
            childRV = itemView.findViewById(R.id.childRV);

        }
    }
}
