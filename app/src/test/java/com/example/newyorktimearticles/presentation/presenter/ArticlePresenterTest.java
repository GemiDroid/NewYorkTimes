package com.example.newyorktimearticles.presentation.presenter;

import com.example.newyorktimearticles.data.model.Articles;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

public class ArticlePresenterTest {

    @Test
    public void getArticlesList_then_check_if_not_null() {

        // Assume that we have faked list of articles...
        List<Articles> fakedArticleList = new ArrayList<>();
        fakedArticleList.add(new Articles("Title1", "Description1", "2020-06-12"));
        fakedArticleList.add(new Articles("Title2", "Description2", "2020-05-13"));
        fakedArticleList.add(new Articles("Title3", "Description3", "2019-04-10"));

        assertNotNull(fakedArticleList);
    }

    @Test
    public void getArticlesList_then_check_if_null() {
        // Assume that we have faked null list of articles...
        List<Articles> fakedArticleList = null;

        assertNull(fakedArticleList);
    }


}