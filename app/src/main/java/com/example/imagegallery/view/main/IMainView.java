package com.example.imagegallery.view.main;

import com.example.imagegallery.model.Data;

public interface IMainView {
    void getData(Data data);
    void error(String error);
}
