package com.example.imagegallery.view.main;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.imagegallery.R;
import com.example.imagegallery.controlle.ImageController;
import com.example.imagegallery.model.Data;
import com.example.imagegallery.model.Photo;
import com.example.imagegallery.view.main.adapter.AdapterClick;
import com.example.imagegallery.view.main.adapter.AdapterSearch;
import com.example.imagegallery.view.main.adapter.ILoadMore;
import com.example.imagegallery.view.size.SizeActivity;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements IMainView, AdapterClick {

    private RecyclerView mRecyclerView;
    private AdapterSearch mAdapter;
    private List<Photo> listPhotos;
    private int countPager = 1;
    private int totalPager = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listPhotos = new ArrayList<>();

        ImageController.getInstance().getSearch(this, this.countPager);

        mRecyclerView = findViewById(R.id.rc_search);

        GridLayoutManager layoutManager =
                new GridLayoutManager(getBaseContext(), 2);
        mRecyclerView.setLayoutManager(layoutManager);

        mAdapter = new AdapterSearch(listPhotos, this, mRecyclerView);
        mAdapter.setLoadMore(new ILoadMore() {
            @Override
            public void onLoadMore() {
                if (listPhotos.size() != totalPager) {
                    listPhotos.add(null);
                    mAdapter.notifyItemInserted(listPhotos.size() - 1);

                    ImageController.getInstance().getSearch(MainActivity.this, countPager++);
                }
            }
        });
        mRecyclerView.setAdapter(mAdapter);

    }

    @Override
    public void getData(final Data data) {

        if (!this.listPhotos.isEmpty()) {
            listPhotos.remove(listPhotos.size() - 1);
            mAdapter.notifyItemRemoved(listPhotos.size());
            mAdapter.setLoading();
        }

        this.totalPager = Integer.parseInt(data.getPhotos().getTotal());
        this.listPhotos.addAll(data.getPhotos().getPhoto());
        mAdapter.notifyDataSetChanged();

        listPhotos.addAll(data.getPhotos().getPhoto());

    }

    @Override
    public void error(String error) {
        Toast.makeText(getBaseContext(),error,Toast.LENGTH_LONG).show();
    }

    @Override
    public void onClick(View view, int position, Photo photo) {
        Intent intent = new Intent(this, SizeActivity.class);
        Bundle bundle = new Bundle();
        bundle.putSerializable("photo", photo);
        intent.putExtras(bundle);
        startActivity(intent);
    }

}
