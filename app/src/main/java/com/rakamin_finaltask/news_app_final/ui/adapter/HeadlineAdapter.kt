// HeadlineAdapter
package com.rakamin_finaltask.news_app_final.ui.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.rakamin_finaltask.news_app_final.R
import com.rakamin_finaltask.news_app_final.databinding.ItemHeadlineBinding
import com.rakamin_finaltask.news_app_final.remote.response.ArticlesItem
import com.rakamin_finaltask.news_app_final.utils.DateFormatter

class HeadlineAdapter : RecyclerView.Adapter<HeadlineAdapter.HeadlineViewHolder>() {

    private val articles = mutableListOf<ArticlesItem>()

    @SuppressLint("NotifyDataSetChanged")
    fun submitList(newArticles: List<ArticlesItem>) {
        articles.clear()
        articles.addAll(newArticles)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HeadlineViewHolder {
        val binding = ItemHeadlineBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return HeadlineViewHolder(binding)
    }

    override fun onBindViewHolder(holder: HeadlineViewHolder, position: Int) {
        holder.bind(articles[position])
    }

    override fun getItemCount(): Int = articles.size

    class HeadlineViewHolder(private val binding: ItemHeadlineBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(article: ArticlesItem) {
            binding.tvHeadlineTitle.text = article.title
            binding.tvHeadlinePublished.text = DateFormatter.formatDate(article.publishedAt)
            binding.tvHeadlineAuthor.text = article.author
            Glide.with(binding.imgHeadline.context)
                .load(article.urlToImage)
                .apply(
                    RequestOptions.placeholderOf(R.drawable.ic_loading).error(R.drawable.ic_error)
                )
                .into(binding.imgHeadline)
        }
    }
}
