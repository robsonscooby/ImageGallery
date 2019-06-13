package com.example.imagegallery.repository;

import com.example.imagegallery.config.IRetrofitConfig;
import com.example.imagegallery.config.Routers;
import com.example.imagegallery.model.Data;
import com.example.imagegallery.model.DataSize;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ImageRepository {

    private static ImageRepository imageRepository = null;

    private ImageRepository(){}

    public static ImageRepository getInstance(){
        if(imageRepository == null){
            imageRepository = new ImageRepository();
            return imageRepository;
        }
        return imageRepository;
    }

    public void getSize( String id, final CallBackSize callBack){
        Routers routers = IRetrofitConfig.retrofit.create(Routers.class);

        Call<DataSize> size =  routers.getSize(id);
        size.enqueue(new Callback<DataSize>() {
            @Override
            public void onResponse(Call<DataSize> call, Response<DataSize> response) {
                if(response.isSuccessful()) {
                    callBack.success(response.body());
                }
            }

            @Override
            public void onFailure(Call<DataSize> call, Throwable t) {
                callBack.error(t);
            }
        });
    }

    public void getSearch(int page, final CallBack callBack){
        Routers routers = IRetrofitConfig.retrofit.create(Routers.class);

        Call<Data> search =  routers.getSearch(page);
        search.enqueue(new Callback<Data>() {
            @Override
            public void onResponse(Call<Data> call, Response<Data> response) {
                if(response.isSuccessful()) {
                    callBack.success(response.body());
                }
            }

            @Override
            public void onFailure(Call<Data> call, Throwable t) {
                callBack.error(t);
            }
        });
    }
}
