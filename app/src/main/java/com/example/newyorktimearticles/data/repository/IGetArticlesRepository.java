package com.example.newyorktimearticles.data.repository;

import com.example.newyorktimearticles.data.model.Result;

import io.reactivex.Single;

public interface IGetArticlesRepository {
    Single<Result> getArticleList();
}
