package com.example.newyorktimearticles.data.webservice;

import com.example.newyorktimearticles.data.model.Result;

import io.reactivex.Single;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiService {
    @GET("mostpopular/v2/viewed/7.json")
    Single<Result> getPopularArticles(@Query("api-key") String ApiKey);
}
