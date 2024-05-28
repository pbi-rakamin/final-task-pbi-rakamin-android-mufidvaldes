package com.rakamin_finaltask.news_app_final.data.di

import android.content.Context

import com.rakamin_finaltask.news_app_final.utils.AppExecutors
import com.rakamin_finaltask.news_app_final.data.local.NewsDatabase
import com.rakamin_finaltask.news_app_final.remote.retrofit.ApiConfig
import com.rakamin_finaltask.news_app_final.repository.NewsRepository

object Injection {
    fun provideRepository(context: Context) {
        val apiService = ApiConfig.getApiService()
        val database = NewsDatabase.getInstance(context)
        val dao = database.newsDao()
        val appExecutors = AppExecutors()
//        return NewsRepository.getInstance(apiService, dao, appExecutors)
    }
}