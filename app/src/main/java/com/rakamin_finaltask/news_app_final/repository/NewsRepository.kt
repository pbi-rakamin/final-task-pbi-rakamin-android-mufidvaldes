package com.rakamin_finaltask.news_app_final.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.rakamin_finaltask.news_app_final.remote.response.ArticlesItem
import com.rakamin_finaltask.news_app_final.remote.response.NewsResponse
import com.rakamin_finaltask.news_app_final.remote.retrofit.ApiConfig
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class NewsRepository {
    private val apiService = ApiConfig.getApiService()

    fun getTopHeadlines(apiKey: String): LiveData<List<ArticlesItem>> {
        val data = MutableLiveData<List<ArticlesItem>>()
        apiService.getTopHeadlines("id", apiKey).enqueue(object : Callback<NewsResponse> {
            override fun onResponse(call: Call<NewsResponse>, response: Response<NewsResponse>) {
                if (response.isSuccessful) {
                    data.value = response.body()?.articles
                }
            }

            override fun onFailure(call: Call<NewsResponse>, t: Throwable) {
                data.value = emptyList()
            }
        })
        return data
    }

    fun getEverything(query: String, apiKey: String): LiveData<List<ArticlesItem>> {
        val data = MutableLiveData<List<ArticlesItem>>()
        apiService.getEverything(query, apiKey).enqueue(object : Callback<NewsResponse> {
            override fun onResponse(call: Call<NewsResponse>, response: Response<NewsResponse>) {
                if (response.isSuccessful) {
                    data.value = response.body()?.articles
                }
            }

            override fun onFailure(call: Call<NewsResponse>, t: Throwable) {
                data.value = emptyList()
            }
        })
        return data
    }
}