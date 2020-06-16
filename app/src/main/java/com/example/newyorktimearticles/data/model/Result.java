package com.example.newyorktimearticles.data.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Result {
    @SerializedName("results")
    @Expose
    private List<Articles> articlesList;

    public List<Articles> getArticlesList() {
        return articlesList;
    }
}
