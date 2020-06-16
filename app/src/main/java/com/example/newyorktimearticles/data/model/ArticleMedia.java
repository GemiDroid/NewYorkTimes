package com.example.newyorktimearticles.data.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

public class ArticleMedia implements Serializable {
    @SerializedName("caption")
    @Expose
    private String caption;
    @SerializedName("media-metadata")
    @Expose
    private List<MetaData> metaDataList;

    public List<MetaData> getMetaDataList() {
        return metaDataList;
    }

    public String getCaption() {
        return caption;
    }
}
