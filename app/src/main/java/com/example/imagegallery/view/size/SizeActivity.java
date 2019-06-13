package com.example.imagegallery.view.size;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.imagegallery.controlle.ImageController;
import com.example.imagegallery.model.DataSize;
import com.example.imagegallery.model.Photo;
import com.example.imagegallery.view.main.adapter.AdapterSearch;
import com.example.imagegallery.view.size.adapter.AdapterSize;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.imagegallery.R;

public class SizeActivity extends AppCompatActivity implements ISizeView{

    private RecyclerView mRecyclerView;
    private AdapterSize mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_size);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        Bundle bundle = getIntent().getExtras();
        if(bundle != null) {
            Photo photo = (Photo) bundle.get("photo");
            getSupportActionBar().setTitle(photo.getTitle());
            ImageController.getInstance().getSize(photo.getId(), this);
        }

        mRecyclerView = findViewById(R.id.rc_size);
    }

    @Override
    public void getData(DataSize data) {
        GridLayoutManager layoutManager =
                new GridLayoutManager(getBaseContext(), 2);
        mRecyclerView.setLayoutManager(layoutManager);

        mAdapter = new AdapterSize(this, data);
        mRecyclerView.setAdapter(mAdapter);
    }

    @Override
    public void error(String error) {
        Toast.makeText(getBaseContext(),error,Toast.LENGTH_LONG).show();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            finish();
        } return super.onOptionsItemSelected(item);
    }
}
