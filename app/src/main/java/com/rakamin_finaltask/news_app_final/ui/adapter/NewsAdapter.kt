package com.rakamin_finaltask.news_app_final.ui.adapter

import android.annotation.SuppressLint
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.rakamin_finaltask.news_app_final.databinding.ItemNewsBinding
import com.rakamin_finaltask.news_app_final.remote.response.ArticlesItem
import com.rakamin_finaltask.news_app_final.ui.DetailNewsActivity
import com.rakamin_finaltask.news_app_final.utils.DateFormatter

class NewsAdapter : RecyclerView.Adapter<NewsAdapter.NewsViewHolder>() {

    private val articles = mutableListOf<ArticlesItem>()

    @SuppressLint("NotifyDataSetChanged")
    fun submitList(newArticles: List<ArticlesItem>) {
        articles.clear()
        articles.addAll(newArticles)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsViewHolder {
        val binding = ItemNewsBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return NewsViewHolder(binding)
    }

    override fun onBindViewHolder(holder: NewsViewHolder, position: Int) {
        holder.bind(articles[position])
    }

    override fun getItemCount(): Int = articles.size

    class NewsViewHolder(private val binding: ItemNewsBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(article: ArticlesItem) {
            binding.tvItemTitle.text = article.title
            binding.tvItemPublishedDate.text = DateFormatter.formatDate(article.publishedAt)
            binding.tvAuthor.text = article.author
            Glide.with(binding.imgPoster.context)
                .load(article.urlToImage)
                .into(binding.imgPoster)

            binding.root.setOnClickListener {
                val intent = Intent(it.context, DetailNewsActivity::class.java)
                intent.putExtra("article", article)
                it.context.startActivity(intent)
            }
        }
    }

}
