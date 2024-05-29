package com.rakamin_finaltask.news_app_final.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.rakamin_finaltask.news_app_final.remote.response.ArticlesItem
import com.rakamin_finaltask.news_app_final.repository.NewsRepository

class NewsViewModel : ViewModel() {
    private val repository = NewsRepository()

    fun getTopHeadlines(apiKey: String): LiveData<List<ArticlesItem>> {
        return repository.getTopHeadlines(apiKey)
    }

    fun getEverything(query: String, apiKey: String, page: Int): LiveData<List<ArticlesItem>> {
        val articlesLiveData = MutableLiveData<List<ArticlesItem>>()
        repository.getEverything(query, apiKey, page).observeForever {
            val currentArticles = articlesLiveData.value ?: emptyList()
            articlesLiveData.postValue(currentArticles + it)
        }
        return articlesLiveData
    }
}
