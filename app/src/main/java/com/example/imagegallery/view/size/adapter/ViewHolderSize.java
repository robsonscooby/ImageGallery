package com.example.imagegallery.view.size.adapter;


import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.imagegallery.R;

public class ViewHolderSize extends RecyclerView.ViewHolder {

    public ImageView imageView;

    public ViewHolderSize(@NonNull View itemView) {
        super(itemView);
        imageView = itemView.findViewById(R.id.image_size);
    }
}
