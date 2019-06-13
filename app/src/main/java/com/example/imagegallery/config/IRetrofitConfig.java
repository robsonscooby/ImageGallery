package com.example.imagegallery.config;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public interface IRetrofitConfig {

    Retrofit retrofit = new Retrofit.Builder()
            .baseUrl(Path.URL_BASE)
            .addConverterFactory(GsonConverterFactory.create())
            .build();
}
