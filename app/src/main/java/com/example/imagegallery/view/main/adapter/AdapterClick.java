package com.example.imagegallery.view.main.adapter;

import android.view.View;

import com.example.imagegallery.model.Photo;

public interface AdapterClick {
    void onClick(View view, int position, Photo photo);
}
