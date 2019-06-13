package com.example.imagegallery.view.main.adapter;

import android.view.View;
import android.widget.ProgressBar;

import androidx.annotation.NonNull;

import com.example.imagegallery.R;

public class ViewLoadSearch extends ViewHolderSearch {

    public ProgressBar progressBar;

    public ViewLoadSearch(@NonNull View itemView) {
        super(itemView);
        progressBar = itemView.findViewById(R.id.progress_loading);
    }

    public void setLoading(boolean visible){
        progressBar.setIndeterminate(visible);
    }
}
