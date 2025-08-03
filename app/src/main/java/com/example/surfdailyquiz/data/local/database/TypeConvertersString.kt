package com.example.surfdailyquiz.data.local.database

import androidx.room.TypeConverter

class TypeConvertersString {
    @TypeConverter
    fun fromStringList(value: List<String>): String {
        return value.joinToString(separator = "||")
    }

    @TypeConverter
    fun toStringList(value: String): List<String> {
        return if (value.isEmpty()) emptyList() else value.split("||")
    }
}