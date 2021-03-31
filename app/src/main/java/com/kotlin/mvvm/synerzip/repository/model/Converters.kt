package com.kotlin.mvvm.synerzip.repository.model

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.lang.reflect.Type


class Converters {
    companion object {
        @TypeConverter
        @JvmStatic
        fun fromString(value: String?): List<Weather>? {
            val listType: Type = object : TypeToken<List<Weather?>?>() {}.type
            return Gson().fromJson<List<Weather>>(value, listType)
        }

        @TypeConverter
        @JvmStatic
        fun listToString(list: List<Weather?>?): String? {
            val gson = Gson()
            return gson.toJson(list)
        }

        @TypeConverter
        @JvmStatic
        fun fromCoordinates(coordinates: Coordinates?): Double? {
            return coordinates?.lattitude
        }

        @TypeConverter
        @JvmStatic
        fun toCoordinates(coordinates: Double?): Coordinates? {
            return coordinates?.let { Coordinates(it) }
        }

        @TypeConverter
        @JvmStatic
        fun fromMain(main: Main?): Double? {
            return main?.temp
        }

        @TypeConverter
        @JvmStatic
        fun toMain(main: Double?): Main? {
            return main?.let { Main(it) }
        }

        @TypeConverter
        @JvmStatic
        fun fromWind(wind: Wind?): Double? {
            return wind?.speed
        }

        @TypeConverter
        @JvmStatic
        fun toWind(wind: Double?): Wind? {
            return wind?.let { Wind(it) }
        }

        @TypeConverter
        @JvmStatic
        fun fromClouds(wind: Clouds?): Double? {
            return wind?.all
        }

        @TypeConverter
        @JvmStatic
        fun toClouds(wind: Double?): Clouds? {
            return wind?.let { Clouds(it) }
        }

        @TypeConverter
        @JvmStatic
        fun fromClouds(wind: Clouds?): Double? {
            return wind?.all
        }

        @TypeConverter
        @JvmStatic
        fun toClouds(wind: Double?): Clouds? {
            return wind?.let { Clouds(it) }
        }
    }
}