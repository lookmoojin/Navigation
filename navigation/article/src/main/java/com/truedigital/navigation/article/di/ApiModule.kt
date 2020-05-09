package com.truedigital.navigation.article.di

import com.truedigital.navigation.article.data.api.ArticleApi
import com.truedigital.navigation.article.data.api.ArticleApiInterface
import org.koin.dsl.module

val apiModule = module {
    single<ArticleApiInterface> { ArticleApi }
}