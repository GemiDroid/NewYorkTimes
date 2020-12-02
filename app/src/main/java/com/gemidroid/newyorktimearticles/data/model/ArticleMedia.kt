package com.gemidroid.newyorktimearticles.data.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import java.io.Serializable

class ArticleMedia : Serializable {

    val caption: String? = null

    @SerializedName("media-metadata")
    @Expose
    val metaDataList: List<MetaData>? = null
}