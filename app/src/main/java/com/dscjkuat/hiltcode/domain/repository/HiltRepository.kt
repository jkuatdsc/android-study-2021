package com.dscjkuat.hiltcode.domain.repository

import com.dscjkuat.hiltcode.domain.models.PostResponse
import com.dscjkuat.hiltcode.domain.models.UsersResponse
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

interface HiltRepository {
    suspend fun getUsers( limit: Int) : UsersResponse
    suspend fun getUsersPosts(id: String, limit: Int) : PostResponse
}

@Module
@InstallIn(ViewModelComponent::class)
abstract class RepositoryBinding {

    @Binds
  abstract fun provideRepository(impl: HiltRepositoryImpl): HiltRepository
}