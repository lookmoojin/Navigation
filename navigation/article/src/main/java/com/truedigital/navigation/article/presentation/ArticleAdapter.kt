package com.truedigital.navigation.article.presentation

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.truedigital.navigation.article.R
import com.truedigital.navigation.article.domain.model.ArticleModel
import com.truedigital.navigation.article.extension.load
import kotlinx.android.synthetic.main.item_article.view.*

class ArticleAdapter(private val context: Context?) :
    RecyclerView.Adapter<ArticleAdapter.ArticleViewHolder>() {

    private var articleList: MutableList<ArticleModel> = mutableListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ArticleViewHolder {
        return ArticleViewHolder(
            LayoutInflater.from(context).inflate(R.layout.item_article, parent, false)
        )
    }

    override fun getItemCount(): Int = articleList.size

    override fun onBindViewHolder(holder: ArticleViewHolder, position: Int) {
        holder.bind(articleList, position)
    }

    inner class ArticleViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        fun bind(list: List<ArticleModel>, position: Int) = with(itemView) {
            val articleModel = list[position]
            iconImageView.load(
                context = context,
                url = articleModel.thumbnail
            )
            titleTextView.text = articleModel.title ?: ""
            publishDateTextView.text = articleModel.publishDate ?: ""
        }
    }

    fun setArticleList(list: List<ArticleModel>) {
        articleList.clear()
        articleList.addAll(list)
        notifyDataSetChanged()
    }
}