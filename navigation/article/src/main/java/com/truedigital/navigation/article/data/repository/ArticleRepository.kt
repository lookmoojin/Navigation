package com.truedigital.navigation.article.data.repository

import com.truedigital.navigation.article.data.api.ArticleApiInterface
import com.truedigital.navigation.article.data.model.response.ArticleResponse
import io.reactivex.Single

interface ArticleRepository {
    fun getArticleList(): Single<ArticleResponse>
}

class ArticleRepositoryImpl(
    private val articleApiInterface: ArticleApiInterface
) : ArticleRepository {

    override fun getArticleList(): Single<ArticleResponse> {
        return articleApiInterface.getArticleList()
    }
}