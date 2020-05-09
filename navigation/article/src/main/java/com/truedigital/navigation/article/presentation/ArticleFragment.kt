package com.truedigital.navigation.article.presentation

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.truedigital.navigation.article.R
import com.truedigital.navigation.article.extension.gone
import com.truedigital.navigation.article.extension.visible
import kotlinx.android.synthetic.main.fragment_article.*
import org.koin.android.viewmodel.ext.android.viewModel

class ArticleFragment : Fragment(R.layout.fragment_article) {

    private val articleViewModel: ArticleViewModel by viewModel()
    private val articleAdapter: ArticleAdapter by lazy { ArticleAdapter(context) }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initViewModel()
        initView()

        articleViewModel.getArticleList()
    }

    private fun initViewModel() {
        articleViewModel.onShowArticleList().observe(viewLifecycleOwner, Observer { list ->
            articleAdapter.setArticleList(list)
        })
        articleViewModel.onShowLoading().observe(viewLifecycleOwner, Observer {
            loadingView.visible()
        })
        articleViewModel.onHideLoading().observe(viewLifecycleOwner, Observer {
            loadingView.gone()
        })
    }

    private fun initView() {
        articleRecyclerView.apply {
            layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
            adapter = articleAdapter
        }
    }

}