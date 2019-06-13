package com.example.imagegallery.view.main.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.imagegallery.R;
import com.example.imagegallery.model.Photo;

import java.util.List;

public class AdapterSearch extends RecyclerView.Adapter<ViewHolderSearch> {

    private Context context;
    private List<Photo> listPhotos;
    private AdapterClick adapterClick;

    private static final int VIEW_SEARCH = 1;
    private static final int VIEW_LOADING = 0;
    private ILoadMore loadMore;
    private boolean isLoading;
    private int visibleTrashHold = 5;
    private int lastVisibleItem, totalItemCount;

    public AdapterSearch(List<Photo> listPhotos, AdapterClick adapterClick, RecyclerView  recyclerView){
        this.context = context;
        this.listPhotos = listPhotos;
        this.adapterClick = adapterClick;

        final LinearLayoutManager linearLayoutManager = (LinearLayoutManager) recyclerView.getLayoutManager();
        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);

                totalItemCount = linearLayoutManager.getItemCount();
                lastVisibleItem = linearLayoutManager.findLastVisibleItemPosition();
                if (!isLoading && totalItemCount <= (lastVisibleItem + visibleTrashHold)) {

                    if (loadMore != null) {
                        loadMore.onLoadMore();
                    }
                    isLoading = true;
                }
            }
        });
    }

    @NonNull
    @Override
    public ViewHolderSearch onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        RecyclerView.ViewHolder viewHolder = null;
        if(viewType == VIEW_LOADING){
            return new ViewLoadSearch(LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.item_load, parent, false));
        }
        return new ViewHolderSearch(LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_rc_search, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolderSearch holder, final int position) {

        if (holder instanceof ViewLoadSearch) {
            ((ViewLoadSearch) holder).setLoading(true);
        } else {
            final Photo photo = this.listPhotos.get(position);

            holder.id.setText(photo.getId());
            holder.title.setText(photo.getTitle());
            holder.cardView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    adapterClick.onClick(view, position, photo);
                }
            });
        }

    }

    @Override
    public int getItemCount() {
        return this.listPhotos.size() > 0 ? this.listPhotos.size() : 0;
    }

    @Override
    public int getItemViewType(int position) {
        return listPhotos.get(position) != null ? VIEW_SEARCH : VIEW_LOADING;
    }

    public void setLoadMore(ILoadMore loadMore) {
        this.loadMore = loadMore;
    }

    public void setLoading() {
        isLoading = false;
    }
}


