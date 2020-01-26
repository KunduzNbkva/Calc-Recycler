package com.example.homework5;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class MainViewHolder extends RecyclerView.ViewHolder {
    TextView textViewHolder;
    public MainViewHolder(@NonNull View itemView) {
        super(itemView);
        textViewHolder=itemView.findViewById(R.id.vh_textView);
    }

    public void onBind(String s) {
        textViewHolder.setText(s);
    }
}
