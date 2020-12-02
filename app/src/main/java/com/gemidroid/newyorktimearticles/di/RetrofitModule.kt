package com.gemidroid.newyorktimearticles.di


import com.gemidroid.newyorktimearticles.utility.Constants.BASE_URL
import com.gemidroid.newyorktimearticles.utility.Constants.CONNECTION_TIME_OUT
import com.gemidroid.newyorktimearticles.utility.Constants.READ_TIME_OUT
import com.gemidroid.newyorktimearticles.utility.Constants.WRITE_TIME_OUT
import com.google.gson.GsonBuilder
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

val retrofitModule = module {

    factory {
        val interceptor = HttpLoggingInterceptor()
        interceptor.level = HttpLoggingInterceptor.Level.BODY

        OkHttpClient.Builder().addInterceptor(interceptor)
                .connectTimeout(CONNECTION_TIME_OUT, TimeUnit.SECONDS)
                .readTimeout(READ_TIME_OUT, TimeUnit.SECONDS)
                .writeTimeout(WRITE_TIME_OUT, TimeUnit.SECONDS)
                .build()
    }

    factory {
        GsonBuilder()
                .setLenient()
                .create()
    }

    single {
        Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addCallAdapterFactory(CoroutineCallAdapterFactory())
                .addConverterFactory(GsonConverterFactory.create(get()))
                .client(get())
                .build()
    }
}