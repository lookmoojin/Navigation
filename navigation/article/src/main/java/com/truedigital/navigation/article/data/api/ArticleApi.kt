package com.truedigital.navigation.article.data.api

import com.truedigital.navigation.article.data.interceptor.ServiceFactory
import retrofit2.converter.gson.GsonConverterFactory

object ArticleApi : ArticleApiInterface by ServiceFactory.baseRetrofit
    .addConverterFactory(GsonConverterFactory.create())
    .baseUrl("http://www.mocky.io/")
    .build()
    .create(ArticleApiInterface::class.java) {
}