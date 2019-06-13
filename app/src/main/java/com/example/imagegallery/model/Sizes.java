
package com.example.imagegallery.model;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class Sizes {

    @SerializedName("canblog")
    private Integer canblog;
    @SerializedName("canprint")
    private Integer canprint;
    @SerializedName("candownload")
    private Integer candownload;
    @SerializedName("size")
    private List<Size> size = null;

    public Integer getCanblog() {
        return canblog;
    }

    public void setCanblog(Integer canblog) {
        this.canblog = canblog;
    }

    public Integer getCanprint() {
        return canprint;
    }

    public void setCanprint(Integer canprint) {
        this.canprint = canprint;
    }

    public Integer getCandownload() {
        return candownload;
    }

    public void setCandownload(Integer candownload) {
        this.candownload = candownload;
    }

    public List<Size> getSize() {
        return size;
    }

    public void setSize(List<Size> size) {
        this.size = size;
    }

}
