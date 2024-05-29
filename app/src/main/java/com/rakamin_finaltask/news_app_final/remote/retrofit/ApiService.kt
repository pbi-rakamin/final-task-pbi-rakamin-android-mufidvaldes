package com.rakamin_finaltask.news_app_final.remote.retrofit

import com.rakamin_finaltask.news_app_final.remote.response.NewsResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    @GET("top-headlines")
    fun getTopHeadlines(
        @Query("country") country: String,
        @Query("apiKey") apiKey: String
    ): Call<NewsResponse>

    @GET("everything")
    fun getEverything(
        @Query("q") query: String,
        @Query("apiKey") apiKey: String,
        @Query("page") page: Int
    ): Call<NewsResponse>
}
