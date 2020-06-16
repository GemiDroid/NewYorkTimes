package com.example.newyorktimearticles.domain;

import com.example.newyorktimearticles.base.UseCase;
import com.example.newyorktimearticles.data.model.Result;
import com.example.newyorktimearticles.data.repository.GetArticlesRepository;
import com.example.newyorktimearticles.data.repository.IGetArticlesRepository;

import io.reactivex.Single;

public class GetArticleUseCase implements UseCase<Void, Single<Result>> {
    private IGetArticlesRepository getArticlesRepository;

    public GetArticleUseCase() {
        getArticlesRepository = new GetArticlesRepository();
    }

    @Override
    public Single<Result> execute(Void value) {
        return getArticlesRepository.getArticleList();
    }
}
