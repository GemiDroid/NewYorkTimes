package com.gemidroid.newyorktimearticles.data.repository

import com.gemidroid.newyorktimearticles.data.model.Result
import com.gemidroid.newyorktimearticles.data.webservice.ApiService
import com.gemidroid.newyorktimearticles.utility.Constants
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf

class GetArticlesRepository(private var apiService: ApiService) : IGetArticlesRepository {

    override suspend fun getArticleList(): Flow<Result> {
        return flowOf(apiService.getPopularArticles(Constants.apiKey))
    }
}