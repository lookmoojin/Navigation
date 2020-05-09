package com.truedigital.navigation.article.data.interceptor

import okhttp3.Interceptor
import okhttp3.Response

class ContentTypeInterceptor(private val contentType: String) : Interceptor {

    companion object {
        private const val HEADER_KEY_CONTENT_TYPE = "Content-Type"
        const val CONTENT_TYPE_JSON = "application/json"
    }

    override fun intercept(chain: Interceptor.Chain): Response {
        val newRequest = chain.request().newBuilder()
            .header(HEADER_KEY_CONTENT_TYPE, contentType)
            .build()

        return chain.proceed(newRequest)
    }

}