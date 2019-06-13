package com.example.imagegallery.repository;

import com.example.imagegallery.model.Data;

public interface CallBack {
    void success(Data data);
    void error(Throwable throwable);
}
