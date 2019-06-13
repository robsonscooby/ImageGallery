package com.example.imagegallery.view.main.adapter;


import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;

import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.imagegallery.R;

public class ViewHolderSearch extends RecyclerView.ViewHolder {

    public TextView title;
    public TextView id;
    public CardView cardView;

    public ViewHolderSearch(@NonNull View itemView) {
        super(itemView);
        title = itemView.findViewById(R.id.tx_title);
        id = itemView.findViewById(R.id.tx_id);
        cardView = itemView.findViewById(R.id.card_view);
    }
}
