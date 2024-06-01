//news response
package com.rakamin_finaltask.news_app_final.remote.response

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

data class NewsResponse(

    @field:SerializedName("totalResults")
    val totalResults: Int,

    @field:SerializedName("articles")
    val articles: List<ArticlesItem>,

    @field:SerializedName("status")
    val status: String
)
@Parcelize
data class Source(

    @field:SerializedName("name")
    val name: String,

    @field:SerializedName("id")
    val id: String?
): Parcelable
@Parcelize
data class ArticlesItem(

    @field:SerializedName("publishedAt")
    val publishedAt: String,

    @field:SerializedName("author")
    val author: String,

    @field:SerializedName("urlToImage")
    val urlToImage: String,

    @field:SerializedName("description")
    val description: String,

    @field:SerializedName("source")
    val source: Source,

    @field:SerializedName("title")
    val title: String,

    @field:SerializedName("url")
    val url: String,

    @field:SerializedName("content")
    val content: String?
): Parcelable
