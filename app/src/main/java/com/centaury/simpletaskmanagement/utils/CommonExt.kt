package com.centaury.simpletaskmanagement.utils

import android.content.Context
import android.view.View
import android.widget.Toast

fun View.visible() {
    visibility = View.VISIBLE
}

fun View.gone() {
    visibility = View.GONE
}

fun Context.showToast(
    res: String,
    duration: Int = Toast.LENGTH_SHORT,
) {
    Toast.makeText(this, res, duration).show()
}