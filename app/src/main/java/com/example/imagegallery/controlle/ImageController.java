package com.example.imagegallery.controlle;

import android.util.Log;

import com.example.imagegallery.repository.CallBack;
import com.example.imagegallery.repository.CallBackSize;
import com.example.imagegallery.repository.ImageRepository;
import com.example.imagegallery.model.Data;
import com.example.imagegallery.model.DataSize;
import com.example.imagegallery.view.main.IMainView;
import com.example.imagegallery.view.size.ISizeView;

public class ImageController {
    private static ImageController imageController = null;

    private ImageController(){}

    public static ImageController getInstance(){
        if(imageController == null){
            imageController = new ImageController();
            return imageController;
        }
        return imageController;
    }

    public void getSize(String id, final ISizeView view){
        ImageRepository.getInstance().getSize(id, new CallBackSize() {
            @Override
            public void success(DataSize data) {
                view.getData(data);
            }

            @Override
            public void error(Throwable throwable) {
                view.error(throwable.getMessage());
            }
        });
    }

    public void getSearch(final IMainView view, int page){
        ImageRepository.getInstance().getSearch(page, new CallBack() {
            @Override
            public void success(Data data) {
                view.getData(data);
            }

            @Override
            public void error(Throwable throwable) {
                view.error(throwable.getMessage());
            }
        });
    }

}
