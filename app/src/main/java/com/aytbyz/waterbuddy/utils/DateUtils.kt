package com.aytbyz.waterbuddy.utils

import android.annotation.SuppressLint
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

object DateUtils {
    @SuppressLint("ConstantLocale")
    private val formatter = SimpleDateFormat("dd MMM yyyy - HH:mm", Locale("tr"))

    fun formatTimestamp(timestamp: Long): String {
        return formatter.format(Date(timestamp))
    }
}