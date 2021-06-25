package com.dscjkuat.hiltcode.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.dscjkuat.hiltcode.domain.models.Post
import com.dscjkuat.hiltcode.domain.models.User

@TypeConverters(Converters::class)
@Database(entities = [Post::class, User::class], version = 2, exportSchema = false)
abstract class HiltDatabase : RoomDatabase(){
    abstract fun dao(): HiltDao
}