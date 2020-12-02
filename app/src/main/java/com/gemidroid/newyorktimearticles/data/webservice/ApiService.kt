package com.gemidroid.newyorktimearticles.data.webservice

import com.gemidroid.newyorktimearticles.data.model.Result
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    @GET("mostpopular/v2/viewed/7.json")
    suspend fun getPopularArticles(@Query("api-key") ApiKey: String): Result
}