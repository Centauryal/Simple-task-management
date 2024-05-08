package com.centaury.simpletaskmanagement.utils

import android.annotation.SuppressLint
import java.text.ParseException
import java.text.SimpleDateFormat
import java.util.Date

@SuppressLint("SimpleDateFormat")
fun Date.formatDate(): String {
    return try {
        val outputDate = SimpleDateFormat("MMM d")
        val date = outputDate.format(this)
        date
    } catch (e: ParseException) {
        e.printStackTrace().toString()
    }
}