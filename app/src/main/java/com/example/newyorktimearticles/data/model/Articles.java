package com.example.newyorktimearticles.data.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

public class Articles implements Serializable {
    @SerializedName("title")
    @Expose
    private String title;
    @SerializedName("abstract")
    @Expose
    private String description;
    @SerializedName("media")
    @Expose
    private List<ArticleMedia> media;
    @SerializedName("published_date")
    @Expose
    private String publishDate;

    public Articles(String title, String description) {
        this.title = title;
        this.description = description;
    }

    public Articles(String title, String description, String publishDate) {
        this.title = title;
        this.description = description;
        this.publishDate = publishDate;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public List<ArticleMedia> getMedia() {
        return media;
    }

    public String getPublishDate() {
        return publishDate;
    }
}
