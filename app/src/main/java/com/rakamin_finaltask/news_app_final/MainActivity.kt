// MainActivity.kt
package com.rakamin_finaltask.news_app_final

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.rakamin_finaltask.news_app_final.databinding.ActivityMainBinding
import com.rakamin_finaltask.news_app_final.ui.adapter.HeadlineAdapter
import com.rakamin_finaltask.news_app_final.ui.adapter.NewsAdapter
import com.rakamin_finaltask.news_app_final.viewmodel.NewsViewModel

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var newsAdapter: NewsAdapter
    private lateinit var headlineAdapter: HeadlineAdapter
    private val viewModel: NewsViewModel by viewModels()

    private var isLoading = false
    private var currentPage = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupRecyclerView()
        setupViewPager()
        setupSwipeRefresh()

        observeViewModel()

        loadData()
    }

    private fun observeViewModel() {
        val apiKey = "bccfa96a92a54fce9cd93ec2a8e9f831"
        viewModel.getTopHeadlines(apiKey).observe(this, Observer {
            headlineAdapter.submitList(it)
        })

        viewModel.getEverything("technology", apiKey, currentPage).observe(this, Observer {
            newsAdapter.submitList(it)
        })
    }

    private fun setupRecyclerView() {
        newsAdapter = NewsAdapter()
        binding.rvNewsList.apply {
            layoutManager = LinearLayoutManager(this@MainActivity)
            adapter = newsAdapter
            addOnScrollListener(object : RecyclerView.OnScrollListener() {
                override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                    super.onScrolled(recyclerView, dx, dy)
                    if (!recyclerView.canScrollVertically(1) && !isLoading) {
                        isLoading = true
                        currentPage++
                        loadMoreNews()
                    }
                }
            })
        }
    }

    private fun setupViewPager() {
        headlineAdapter = HeadlineAdapter()
        binding.viewPagerHeadline.adapter = headlineAdapter
        binding.dotsIndicator.setViewPager2(binding.viewPagerHeadline)
    }

    private fun setupSwipeRefresh() {
        binding.swipeRefreshLayout.setOnRefreshListener {
            refreshData()
        }
    }

    private fun refreshData() {
        currentPage = 1
        val apiKey = "bccfa96a92a54fce9cd93ec2a8e9f831"
        viewModel.getTopHeadlines(apiKey).observe(this, Observer {
            headlineAdapter.submitList(it)
            binding.swipeRefreshLayout.isRefreshing = false
        })

        viewModel.getEverything("technology", apiKey, currentPage).observe(this, Observer {
            newsAdapter.submitList(it)
            binding.swipeRefreshLayout.isRefreshing = false
        })
    }

    private fun loadData() {
        val apiKey = "bccfa96a92a54fce9cd93ec2a8e9f831"
        viewModel.getTopHeadlines(apiKey)
        viewModel.getEverything("technology", apiKey, currentPage)
    }

    private fun loadMoreNews() {
        val apiKey = "bccfa96a92a54fce9cd93ec2a8e9f831"
        viewModel.getEverything("technology", apiKey, currentPage).observe(this, Observer {
            newsAdapter.addItems(it)
            isLoading = false
        })
    }
}
