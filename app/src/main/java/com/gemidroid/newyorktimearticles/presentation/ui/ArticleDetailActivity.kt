package com.gemidroid.newyorktimearticles.presentation.ui

import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import com.gemidroid.newyorktimearticles.R
import com.gemidroid.newyorktimearticles.data.model.Articles
import com.gemidroid.newyorktimearticles.utility.Constants.ARTICLE_KEY

class ArticleDetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_article_detail)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val id = item.itemId
        if (id == android.R.id.home) {
            navigateUpTo(intent)
            return true
        }
        return super.onOptionsItemSelected(item)
    }
}