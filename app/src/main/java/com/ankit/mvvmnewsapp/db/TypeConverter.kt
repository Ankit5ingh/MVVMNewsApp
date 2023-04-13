package com.ankit.mvvmnewsapp.db

import com.ankit.mvvmnewsapp.models.Source

class TypeConverter {
    @androidx.room.TypeConverter
    fun fromSource(source: Source) : String{
        return source.name
    }
    @androidx.room.TypeConverter
    fun toSource(name: String) : Source {
        return Source(name, name)
    }

}