package com.example.newyorktimearticles.presentation.ui;

import com.example.newyorktimearticles.data.ServerException;
import com.example.newyorktimearticles.data.model.Articles;

import java.util.List;

public interface IArticleView {
    void showProgress(Boolean isShown);

    void getArticles(List<Articles> getArticlesList);

    void displayError(ServerException exceptionType);
}
