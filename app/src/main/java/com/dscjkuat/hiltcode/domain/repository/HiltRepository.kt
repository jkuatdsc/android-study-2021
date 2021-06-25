package com.dscjkuat.hiltcode.domain.repository

import com.dscjkuat.hiltcode.domain.models.Post
import com.dscjkuat.hiltcode.domain.models.User
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import kotlinx.coroutines.flow.Flow

interface HiltRepository {
    val users: Flow<List<User>>
    val posts: Flow<List<Post>>
    suspend fun getUsers(limit: Int): Unit
    suspend fun getUsersPosts(id: String, limit: Int): Unit
}

@Module
@InstallIn(ViewModelComponent::class)
abstract class RepositoryBinding {

    @Binds
    abstract fun provideRepository(impl: HiltRepositoryImpl): HiltRepository
}