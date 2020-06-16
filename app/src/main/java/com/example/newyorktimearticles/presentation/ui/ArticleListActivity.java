package com.example.newyorktimearticles.presentation.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.ProgressBar;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.example.newyorktimearticles.R;
import com.example.newyorktimearticles.data.ServerException;
import com.example.newyorktimearticles.data.model.Articles;
import com.example.newyorktimearticles.presentation.presenter.ArticlePresenter;
import com.example.newyorktimearticles.presentation.presenter.IArticlePresenter;
import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;
import java.util.List;

public class ArticleListActivity extends AppCompatActivity implements OnArticleClickListener,
        IArticleView {

    public static final String ARTICLE_KEY = "selected_article";
    IArticlePresenter presenter;
    private ArticlesAdapter articleAdapter;
    private List<Articles> articlesList = new ArrayList<>();
    private ProgressBar progress;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_article_list);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer);
        ActionBarDrawerToggle mDrawerToggle = new ActionBarDrawerToggle(this, mDrawerLayout, toolbar, 0, 0);
        mDrawerLayout.addDrawerListener(mDrawerToggle);
        mDrawerToggle.syncState();

        setUpRecyclerView();
        initProgress();

        presenter = new ArticlePresenter(this);
        presenter.fetchArticles();
    }

    private void initProgress() {
        progress = findViewById(R.id.progress);
    }

    private void setUpRecyclerView() {
        articleAdapter = new ArticlesAdapter(this, articlesList);
        RecyclerView recArticles = findViewById(R.id.recArticleList);
        recArticles.setAdapter(articleAdapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.article_list_menu, menu);
        return true;
    }

    @Override
    public void onArticleClick(Articles article) {
        Intent destination = new Intent(this, ArticleDetailActivity.class);
        destination.putExtra(ArticleListActivity.ARTICLE_KEY, article);
        startActivity(destination);
    }

    @Override
    public void showProgress(Boolean shouldShow) {
        if (shouldShow) progress.setVisibility(View.VISIBLE);
        else progress.setVisibility(View.GONE);
    }

    @Override
    public void getArticles(List<Articles> getArticlesList) {
        articleAdapter.updateArticleList(getArticlesList);
    }

    @Override
    public void displayError(ServerException e) {
        String errorMessage;
        switch (e) {
            case UnKnownHost:
                errorMessage = getString(R.string.no_internet_connection);
                break;
            case Other:
            default:
                errorMessage = getString(R.string.unknown_error);
                break;
        }
        Snackbar.make(progress.getRootView(), errorMessage, Snackbar.LENGTH_SHORT).show();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        presenter.onDestroy();
    }
}