package com.example.appthemoviedb.data.framework.db

import androidx.room.TypeConverter

class Converters {

    @TypeConverter
    fun fromListIntToString(intList: List<Int>): String {
        return intList.toString()
    }

    @TypeConverter
    fun toListIntFromString(stringList: String): List<Int> {
        val result = ArrayList<Int>()
        val split = stringList
            .replace("[", "")
            .replace("]", "")
            .replace(" ", "")
            .split(",")
        for (n in split) {
            result.add(n.toInt())
        }
        return result
    }
}