package com.dscjkuat.hiltcode.domain.repository

import com.dscjkuat.hiltcode.data.local.HiltDao
import com.dscjkuat.hiltcode.data.remote.ApiEndpoints
import com.dscjkuat.hiltcode.domain.models.Post
import com.dscjkuat.hiltcode.domain.models.User
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class HiltRepositoryImpl @Inject constructor(
    private val dao: HiltDao,
    private val api: ApiEndpoints,
) : HiltRepository {
    override val users: Flow<List<User>>
        get() = dao.getUsers()

    override val posts: Flow<List<Post>>
        get() = dao.getPosts()

    override suspend fun getUsers(limit: Int) {

        val result = api.getUser(limit)
        dao.updateUsers(result.data)
    }

    override suspend fun getUsersPosts(id: String, limit: Int) {
        val result = api.getUserPosts(id, limit)
        dao.updatePost(result.data)
    }
}