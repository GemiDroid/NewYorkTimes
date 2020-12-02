package com.gemidroid.newyorktimearticles.domain

import com.gemidroid.newyorktimearticles.data.model.Result
import com.gemidroid.newyorktimearticles.data.repository.IGetArticlesRepository
import kotlinx.coroutines.flow.Flow

class GetArticleUseCase(
    private val articleUseCase: IGetArticlesRepository
) {
    suspend fun getArticles(): Flow<Result> {
        return articleUseCase.getArticleList()
    }
}