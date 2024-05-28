package com.rakamin_finaltask.news_app_final.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.rakamin_finaltask.news_app_final.remote.response.ArticlesItem
import com.rakamin_finaltask.news_app_final.repository.NewsRepository

class NewsViewModel : ViewModel() {
    private val repository = NewsRepository()

    fun getTopHeadlines(apiKey: String): LiveData<List<ArticlesItem>> {
        return repository.getTopHeadlines(apiKey)
    }

    fun getEverything(query: String, apiKey: String): LiveData<List<ArticlesItem>> {
        return repository.getEverything(query, apiKey)
    }
}
