package com.example.homework5;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MainAdapter extends RecyclerView.Adapter<MainViewHolder> {
    public ArrayList<String> data = new ArrayList<>();


    public void update(ArrayList<String> data){
        this.data= data;
        notifyDataSetChanged();
    }

    public void addText(String text) {
        data.add(text);
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public MainViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View v = layoutInflater.inflate(R.layout.view_holder_main, parent, false);
        MainViewHolder viewHolder = new MainViewHolder(v);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MainViewHolder holder, int position) {
     //   holder.textViewHolder.setText(data.get(position));
        holder.onBind(data.get(position));

    }

    @Override
    public int getItemCount() {
        return data.size();
    }
}
