package com.rakamin_finaltask.news_app_final

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.rakamin_finaltask.news_app_final.databinding.ActivityMainBinding
import com.rakamin_finaltask.news_app_final.ui.adapter.HeadlineAdapter
import com.rakamin_finaltask.news_app_final.ui.adapter.NewsAdapter
import com.rakamin_finaltask.news_app_final.viewmodel.NewsViewModel

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var newsAdapter: NewsAdapter
    private lateinit var headlineAdapter: HeadlineAdapter
    private val viewModel: NewsViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupRecyclerView()
        setupViewPager()

        observeViewModel()

    }

    private fun observeViewModel() {
        viewModel.getTopHeadlines("bccfa96a92a54fce9cd93ec2a8e9f831").observe(this, Observer {
            headlineAdapter.submitList(it)
        })

        viewModel.getEverything("technology", "bccfa96a92a54fce9cd93ec2a8e9f831").observe(this, Observer {
            newsAdapter.submitList(it)
        })
    }

    private fun setupRecyclerView() {
        newsAdapter = NewsAdapter()
        binding.rvNewsList.apply {
            layoutManager = LinearLayoutManager(this@MainActivity)
            adapter = newsAdapter
        }
    }

    private fun setupViewPager() {
        headlineAdapter = HeadlineAdapter()
        binding.viewPagerHeadline.adapter = headlineAdapter
    }
}
