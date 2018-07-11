package com.shurik.gym.database

import android.arch.persistence.room.TypeConverter
import java.util.*

class DateConverter {

    @TypeConverter
    fun fromTimestamp(value: String): Calendar {
        val arr = value.split("-")
        val cal = Calendar.getInstance()
        cal.set(arr[0].toInt(), arr[1].toInt(), arr[2].toInt())
        return cal
    }

    @TypeConverter
    fun dateToTimestamp(date: Calendar): String {
        return "${date.get(Calendar.DATE)}-${date.get(Calendar.MONTH)+1}-${date.get(Calendar.YEAR)}"
    }
}