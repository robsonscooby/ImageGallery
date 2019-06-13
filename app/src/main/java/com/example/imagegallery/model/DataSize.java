
package com.example.imagegallery.model;

import com.google.gson.annotations.SerializedName;

public class DataSize {

    @SerializedName("sizes")
    private Sizes sizes;
    @SerializedName("stat")
    private String stat;

    public Sizes getSizes() {
        return sizes;
    }

    public void setSizes(Sizes sizes) {
        this.sizes = sizes;
    }

    public String getStat() {
        return stat;
    }

    public void setStat(String stat) {
        this.stat = stat;
    }

}
