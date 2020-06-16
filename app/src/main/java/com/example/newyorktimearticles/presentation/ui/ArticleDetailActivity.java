package com.example.newyorktimearticles.presentation.ui;

import android.os.Bundle;
import android.view.MenuItem;

import androidx.appcompat.app.AppCompatActivity;

import com.example.newyorktimearticles.R;
import com.example.newyorktimearticles.data.model.Articles;

public class ArticleDetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_article_detail);

        Articles article = getIntent().getSerializableExtra(ArticleListActivity.ARTICLE_KEY) != null
                ? (Articles) getIntent().getSerializableExtra(ArticleListActivity.ARTICLE_KEY)
                : new Articles("Title", "Description");

        getSupportFragmentManager().beginTransaction()
                .add(R.id.container, ArticleDetailFragment.newInstance(article))
                .commit();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == android.R.id.home) {
            navigateUpTo(getIntent());
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}