package com.dscjkuat.hiltcode.data.remote

import com.dscjkuat.hiltcode.domain.models.PostResponse
import com.dscjkuat.hiltcode.domain.models.UsersResponse
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiEndpoints {
    @GET("/data/api/user")
    suspend fun getUser(@Query("limit") limit: Int): UsersResponse

    @GET("/data/api/user/{id}/post")
    suspend fun getUserPosts(@Path("id") id: String, @Query("limit") limit: Int): PostResponse
}