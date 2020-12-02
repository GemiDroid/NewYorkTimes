package com.gemidroid.newyorktimearticles.presentation

import com.gemidroid.newyorktimearticles.data.model.Articles
import org.junit.Assert
import org.junit.Test
import java.util.*

class ArticlePresenterTest {
    // Assume that we have faked list of articles...
    @Test
    fun articlesList_then_check_if_not_null() {
        // Assume that we have faked list of articles...
        val fakedArticleList: MutableList<Articles> = ArrayList()
        fakedArticleList.add(Articles("Title1", "Description1", "2020-06-12"))
        fakedArticleList.add(Articles("Title2", "Description2", "2020-05-13"))
        fakedArticleList.add(Articles("Title3", "Description3", "2019-04-10"))
        Assert.assertNotNull(fakedArticleList)
    }

    // Assume that we have faked null list of articles...
    @Test
    fun articlesList_then_check_if_null() {
        // Assume that we have faked null list of articles...
        val fakedArticleList: List<Articles>? = null
        Assert.assertNull(fakedArticleList)
    }
}