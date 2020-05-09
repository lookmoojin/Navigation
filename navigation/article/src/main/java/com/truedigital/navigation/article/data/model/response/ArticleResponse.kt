package com.truedigital.navigation.article.data.model.response

import com.google.gson.annotations.SerializedName

class ArticleResponse {

    @SerializedName("data")
    val dataList: List<ArticleItem>? = null

    class ArticleItem {
        @SerializedName("id")
        val id: String? = null
        @SerializedName("title")
        val title: String? = null
        @SerializedName("thumb_url")
        val thumbUrl: String? = null
        @SerializedName("author")
        val author: String? = null
        @SerializedName("clap")
        val clap: Int = 0
        @SerializedName("size")
        val size: Int = 0
        @SerializedName("detail_url")
        val detailUrl: String? = null
        @SerializedName("publish_date")
        val publishDate: String? = null
        @SerializedName("publish_status")
        val publishStatus: Boolean? = null
    }
}
