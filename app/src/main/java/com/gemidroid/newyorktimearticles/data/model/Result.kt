package com.gemidroid.newyorktimearticles.data.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class Result {
    @SerializedName("results")
    @Expose
    val articlesList: List<Articles>? = null
}