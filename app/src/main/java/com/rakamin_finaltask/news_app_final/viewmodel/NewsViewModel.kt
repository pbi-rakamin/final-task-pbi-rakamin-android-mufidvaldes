// NewsViewModel.kt
package com.rakamin_finaltask.news_app_final.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.rakamin_finaltask.news_app_final.remote.response.ArticlesItem
import com.rakamin_finaltask.news_app_final.repository.NewsRepository

class NewsViewModel(application: Application) : AndroidViewModel(application) {
    private val repository = NewsRepository()

    fun getTopHeadlines(apiKey: String): LiveData<List<ArticlesItem>> {
        return repository.getTopHeadlines(apiKey)
    }

    fun getEverything(query: String, apiKey: String, page: Int): LiveData<List<ArticlesItem>> {
        val articlesLiveData = MutableLiveData<List<ArticlesItem>>()
        repository.getEverything(query, apiKey, page).observeForever {
            val currentArticles = articlesLiveData.value ?: emptyList()
            articlesLiveData.value = currentArticles + it
        }
        return articlesLiveData
    }
}
