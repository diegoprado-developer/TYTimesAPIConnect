package com.diegoprado.nytimesapiconnect.data.database.converts

import androidx.room.TypeConverter
import com.diegoprado.nytimesapiconnect.data.database.entity.BooksEntity
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken



class Converters {

//    @TypeConverter
//    fun arrayListToJson(value: Array<BooksEntity.BookDetail>?): String {
//        return  Gson().toJson(value)
//    }
//
//    @TypeConverter
//    fun jsonToArrayList(value: String): List<BooksEntity.BookDetail> {
//        val objects = Gson().fromJson(value, Array<BooksEntity.BookDetail>::class.java) as Array<BooksEntity.BookDetail>
//        val list = objects.toList()
//        return list
//    }

    @TypeConverter
    fun stringToMeasurements(json: String): List<BooksEntity.BookDetail> {
        val gson = Gson()
        val type = object : TypeToken<List<BooksEntity.BookDetail>>() {

        }.type
        return gson.fromJson(json, type)
    }

    @TypeConverter
    fun measurementsToString(list: List<BooksEntity.BookDetail>): String {
        val gson = Gson()
        val type = object : TypeToken<List<BooksEntity.BookDetail>>() {

        }.type
        return gson.toJson(list, type)
    }
}