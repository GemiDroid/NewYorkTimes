package com.example.newyorktimearticles.data.repository;

import com.example.newyorktimearticles.data.model.Result;
import com.example.newyorktimearticles.data.webservice.ApiService;
import com.example.newyorktimearticles.data.webservice.Constants;

import io.reactivex.Single;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class GetArticlesRepository implements IGetArticlesRepository {
    ApiService apiService;

    public GetArticlesRepository() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Constants.baseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .client(getClient())
                .build();
        apiService = retrofit.create(ApiService.class);
    }

    public OkHttpClient getClient() {
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        return new OkHttpClient.Builder().addInterceptor(interceptor).build();
    }

    @Override
    public Single<Result> getArticleList() {
        return apiService.getPopularArticles(Constants.apiKey);
    }
}
