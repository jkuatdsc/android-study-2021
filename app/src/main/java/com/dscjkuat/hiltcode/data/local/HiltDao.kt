package com.dscjkuat.hiltcode.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.dscjkuat.hiltcode.domain.models.Post
import com.dscjkuat.hiltcode.domain.models.User
import kotlinx.coroutines.flow.Flow
import retrofit2.http.POST

@Dao
interface HiltDao {

    @Insert(entity = User::class, onConflict = OnConflictStrategy.REPLACE)
    suspend fun updateUsers(users: List<User>)

    @Query("SELECT * FROM USER")
    fun getUsers(): Flow<List<User>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun updatePost(posts : List<Post>)

    @Query("SELECT * FROM Post")
    fun getPosts(): Flow<List<Post>>
}