package com.truedigital.navigation.article

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class ArticleActivity : AppCompatActivity(R.layout.activity_article) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.hide()
    }
}
