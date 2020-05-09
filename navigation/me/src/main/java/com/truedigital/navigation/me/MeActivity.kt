package com.truedigital.navigation.me

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class MeActivity : AppCompatActivity(R.layout.activity_me) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.hide()
    }
}