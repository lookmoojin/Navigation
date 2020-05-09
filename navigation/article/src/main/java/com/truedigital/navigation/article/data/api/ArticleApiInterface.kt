package com.truedigital.navigation.article.data.api

import com.truedigital.navigation.article.data.model.response.ArticleResponse
import io.reactivex.Single
import retrofit2.http.GET

interface ArticleApiInterface {

    @GET("v2/5e589a012f0000be0c962001")
    fun getArticleList(): Single<ArticleResponse>
}