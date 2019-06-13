package com.example.imagegallery.view.size.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.imagegallery.R;
import com.example.imagegallery.model.DataSize;
import com.example.imagegallery.model.Size;
import com.squareup.picasso.Picasso;

public class AdapterSize extends RecyclerView.Adapter<ViewHolderSize> {

    private Context context;
    private DataSize data;

    public AdapterSize(Context context, DataSize data){
        this.context = context;
        this.data = data;
    }

    @NonNull
    @Override
    public ViewHolderSize onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolderSize(LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_rc_size, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolderSize holder, int position) {
        final Size size = this.data.getSizes().getSize().get(position);

        Picasso.get().load(size.getSource()).into(holder.imageView);

    }

    @Override
    public int getItemCount() {
        return this.data.getSizes().getSize().size() > 0 ? this.data.getSizes().getSize().size() : 0;
    }
}


