package com.truedigital.workshop.di

import com.truedigital.navigation.article.di.apiModule
import com.truedigital.navigation.article.di.articleModule

val dependenciesModuleList = listOf(
    apiModule,
    articleModule
)