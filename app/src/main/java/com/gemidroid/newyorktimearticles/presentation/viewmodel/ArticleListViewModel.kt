package com.gemidroid.newyorktimearticles.presentation.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.gemidroid.newyorktimearticles.data.model.Articles
import com.gemidroid.newyorktimearticles.domain.GetArticleUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class ArticleListViewModel(private val articleUseCase: GetArticleUseCase) : ViewModel() {

    init {
        viewModelScope.launch(Dispatchers.IO) {
            try {
                articleUseCase.getArticles()
                    .collect {
                        observeOnArticleList.postValue(it.articlesList)
                    }
            } catch (e: Throwable) {
                observeOnError.postValue(e)
            }

        }
    }


    val observeOnError = MutableLiveData<Throwable>()
    val observeOnArticleList = MutableLiveData<List<Articles>>()
}