package com.truedigital.navigation.article.data.interceptor

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import java.util.concurrent.TimeUnit

object ServiceFactory {

    val baseRetrofit: Retrofit.Builder = Retrofit.Builder()
        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
        .client(
            createOkHttpClient(
                ContentTypeInterceptor.CONTENT_TYPE_JSON
            )
                .addInterceptor(HeaderInterceptor())
                .build()
        )


    private fun createOkHttpClient(contentType: String): OkHttpClient.Builder {
        return OkHttpClient().newBuilder()
            .readTimeout(3000L, TimeUnit.MILLISECONDS)
            .writeTimeout(3000L, TimeUnit.MILLISECONDS)
            .connectTimeout(3000L, TimeUnit.MILLISECONDS)
            .addInterceptor(ContentTypeInterceptor(contentType))
    }
}