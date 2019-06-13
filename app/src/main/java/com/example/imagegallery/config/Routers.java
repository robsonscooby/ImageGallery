package com.example.imagegallery.config;

import com.example.imagegallery.model.Data;
import com.example.imagegallery.model.DataSize;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface Routers {

    @GET("?method=flickr.photos.search&api_key=9a95c68a9c6ec61104cd3967dcbb8bd3&tags=kitten&format=json&nojsoncallback=1")
    Call<Data> getSearch(@Query("page") int page);

    @GET("?method=flickr.photos.getSizes&api_key=9a95c68a9c6ec61104cd3967dcbb8bd3&format=json&nojsoncallback=1")
    Call<DataSize> getSize(@Query("photo_id") String id);
}
