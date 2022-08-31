package com.ahmaddudayef.mitrais.core.extensions

import android.view.View
import android.view.View.GONE
import android.view.View.VISIBLE
import android.widget.ImageView
import coil.load

fun View.toVisible() {
    this.visibility = VISIBLE
}

fun View.toGone() {
    this.visibility = GONE
}

fun ImageView.loadFromUrl(url: String) {
    if (url.isEmpty()) return
    this.load(url)
}