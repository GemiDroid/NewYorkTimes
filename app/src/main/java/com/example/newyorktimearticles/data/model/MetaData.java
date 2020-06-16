package com.example.newyorktimearticles.data.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class MetaData implements Serializable {
    @SerializedName("url")
    @Expose
    private String imgUrl;

    public String getImgUrl() {
        return imgUrl;
    }
}
