package com.dscjkuat.hiltcode.data.local

import androidx.room.TypeConverter
import com.dscjkuat.hiltcode.domain.models.User
import com.squareup.moshi.JsonAdapter
import com.squareup.moshi.Moshi
import com.squareup.moshi.Types
import java.lang.reflect.Type


class Converters {
    private val type: Type = Types.newParameterizedType(List::class.java, String::class.java)
    private val moshi: Moshi = Moshi.Builder().build()
    private val adapter: JsonAdapter<List<String>> = moshi.adapter<List<String>>(type)
    private val ownerAdapter: JsonAdapter<User> = moshi.adapter(User::class.java)

    @TypeConverter
    fun tagsToJson(tags: List<String>): String = adapter.toJson(tags)

    @TypeConverter
    fun jsonToTags(json: String): List<String> = adapter.fromJson(json)!!

    @TypeConverter
    fun ownerToJson(user: User) : String = ownerAdapter.toJson(user)

    @TypeConverter
    fun jsonToOwner(json: String): User = ownerAdapter.fromJson(json)!!
}