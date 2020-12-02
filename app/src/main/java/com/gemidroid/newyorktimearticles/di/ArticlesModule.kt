package com.gemidroid.newyorktimearticles.di

import com.gemidroid.newyorktimearticles.data.repository.GetArticlesRepository
import com.gemidroid.newyorktimearticles.data.repository.IGetArticlesRepository
import com.gemidroid.newyorktimearticles.data.webservice.ApiService
import com.gemidroid.newyorktimearticles.domain.GetArticleUseCase
import com.gemidroid.newyorktimearticles.presentation.viewmodel.ArticleListViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import retrofit2.Retrofit

val articleModule = module {

    single { get<Retrofit>().create(ApiService::class.java) }
    factory<IGetArticlesRepository> { GetArticlesRepository(get()) }
    factory {  GetArticleUseCase(get()) }
    viewModel { ArticleListViewModel(get()) }

}