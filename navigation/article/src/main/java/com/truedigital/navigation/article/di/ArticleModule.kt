package com.truedigital.navigation.article.di

import com.truedigital.navigation.article.data.repository.ArticleRepository
import com.truedigital.navigation.article.data.repository.ArticleRepositoryImpl
import com.truedigital.navigation.article.domain.usecase.GetArticleListUseCase
import com.truedigital.navigation.article.domain.usecase.GetArticleListUseCaseImpl
import com.truedigital.navigation.article.presentation.ArticleViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

val articleModule = module {
    factory<ArticleRepository> {
        ArticleRepositoryImpl(articleApiInterface = get())
    }
    factory<GetArticleListUseCase> {
        GetArticleListUseCaseImpl(articleRepository = get())
    }
    viewModel {
        ArticleViewModel(getArticleListUseCase = get())
    }
}