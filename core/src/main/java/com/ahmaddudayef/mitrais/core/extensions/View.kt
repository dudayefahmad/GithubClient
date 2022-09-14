package com.ahmaddudayef.mitrais.core.extensions

import android.view.View
import android.view.View.GONE
import android.view.View.VISIBLE
import android.widget.EditText
import android.widget.ImageView
import android.widget.SearchView
import coil.load
import com.google.android.material.snackbar.Snackbar
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

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

fun View.showSnackbar(message: String, action: (Snackbar.() -> Unit)? = null) {
    val snackbar = Snackbar.make(this, message, Snackbar.LENGTH_SHORT)
    action?.let { snackbar.it() }
    snackbar.show()
}
