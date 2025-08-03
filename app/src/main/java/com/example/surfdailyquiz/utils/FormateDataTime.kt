package com.example.surfdailyquiz.utils

import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale
import java.util.TimeZone

fun formatDate(millis: Long): String {
    val dateFormat = SimpleDateFormat("d MMMM", Locale("ru")) // Пример: 3 августа
    dateFormat.timeZone = TimeZone.getDefault()
    return dateFormat.format(Date(millis))
}

fun formatTime(millis: Long): String {
    val timeFormat = SimpleDateFormat("HH:mm", Locale("ru")) // Пример: 20:17
    timeFormat.timeZone = TimeZone.getDefault()
    return timeFormat.format(Date(millis))
}