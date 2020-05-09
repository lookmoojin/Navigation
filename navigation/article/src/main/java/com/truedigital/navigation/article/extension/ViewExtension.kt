package com.truedigital.navigation.article.extension

import android.os.Handler
import android.view.View

fun View.visible() {
    this.visibility = View.VISIBLE
}

fun View.gone() {
    this.visibility = View.GONE
}

fun View.invisible() {
    this.visibility = View.INVISIBLE
}

fun View.onClick(doSomething:() -> Unit) {
    setOnClickListener {
        it.isClickable = false
        Handler().postDelayed({ it.isClickable = true }, 1500)
        doSomething()
    }
}

fun View.goneUnless(visible: Boolean) {
    this.visibility = if (visible) View.VISIBLE else View.GONE
}