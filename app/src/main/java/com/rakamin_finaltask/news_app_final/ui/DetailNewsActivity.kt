package com.rakamin_finaltask.news_app_final.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.rakamin_finaltask.news_app_final.databinding.ActivityDetailNewsBinding
import com.rakamin_finaltask.news_app_final.remote.response.ArticlesItem

class DetailNewsActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailNewsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailNewsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        @Suppress("DEPRECATION")
        val article = intent.getParcelableExtra<ArticlesItem>("article")
        article?.let { showDetail(it) }
    }

    private fun showDetail(article: ArticlesItem) {
        binding.tvDetailTitle.text = article.title
        binding.tvDetailAuthor.text = article.author
        binding.tvDetailPublishedDate.text = article.publishedAt
        binding.tvDetailContent.text = article.content
        Glide.with(this)
            .load(article.urlToImage)
            .into(binding.imgDetailNews)
    }
}
