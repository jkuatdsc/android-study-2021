package com.dscjkuat.hiltcode.domain.repository

import com.dscjkuat.hiltcode.data.remote.ApiEndpoints
import com.dscjkuat.hiltcode.domain.models.PostResponse
import com.dscjkuat.hiltcode.domain.models.UsersResponse
import javax.inject.Inject

class HiltRepositoryImpl @Inject constructor(val api: ApiEndpoints): HiltRepository {

    override suspend fun getUsers(limit: Int): UsersResponse = api.getUser(limit)

    override suspend fun getUsersPosts(id: String, limit: Int): PostResponse = api.getUserPosts(id, limit)
}