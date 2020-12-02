package com.gemidroid.newyorktimearticles.data.repository

import com.gemidroid.newyorktimearticles.data.model.Result
import kotlinx.coroutines.flow.Flow

interface IGetArticlesRepository {
    suspend fun getArticleList(): Flow<Result>
}