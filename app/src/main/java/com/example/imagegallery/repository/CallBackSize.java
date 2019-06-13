package com.example.imagegallery.repository;

import com.example.imagegallery.model.DataSize;

public interface CallBackSize {
    void success(DataSize data);
    void error(Throwable throwable);
}
