package com.gemidroid.newyorktimearticles.data.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import java.io.Serializable

class MetaData : Serializable {
    @SerializedName("url")
    @Expose
    val imgUrl: String? = null
}