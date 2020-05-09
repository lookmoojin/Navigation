package com.truedigital.navigation.article.domain.usecase

import com.truedigital.navigation.article.data.model.response.ArticleResponse
import com.truedigital.navigation.article.data.repository.ArticleRepository
import com.truedigital.navigation.article.domain.model.ArticleModel
import io.reactivex.Single

interface GetArticleListUseCase {
    fun execute(): Single<List<ArticleModel>>
}

class GetArticleListUseCaseImpl(
    private val articleRepository: ArticleRepository
) : GetArticleListUseCase {

    override fun execute(): Single<List<ArticleModel>> {
        return articleRepository.getArticleList()
            .filter { it.dataList?.isNotEmpty() == true }
            .map { it.dataList }
            .map(::toArticleModel)
            .toSingle()
    }

    private fun toArticleModel(list: List<ArticleResponse.ArticleItem>): List<ArticleModel> {
        val mutableArticle = mutableListOf<ArticleModel>()
        list.forEach { item ->
            mutableArticle.add(ArticleModel().apply {
                detailUrl = item.detailUrl
                thumbnail = item.thumbUrl
                title = item.title
                publishDate = item.publishDate
            })
        }
        return mutableArticle.toList()
    }
}