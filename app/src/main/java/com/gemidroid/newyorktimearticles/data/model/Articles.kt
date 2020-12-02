package com.gemidroid.newyorktimearticles.data.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import java.io.Serializable

class Articles : Serializable {
    @SerializedName("title")
    @Expose
    var title: String
        private set

    @SerializedName("abstract")
    @Expose
    var description: String
        private set

    @SerializedName("media")
    @Expose
    val media: List<ArticleMedia>? = null

    @SerializedName("published_date")
    @Expose
    var publishDate: String? = null
        private set

    constructor(title: String, description: String) {
        this.title = title
        this.description = description
    }

    constructor(title: String, description: String, publishDate: String?) {
        this.title = title
        this.description = description
        this.publishDate = publishDate
    }
}