package com.dscjkuat.hiltcode.data.remote

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import javax.inject.Singleton

/**
* @Module annotation defines this object as a container that provides dependencies
* @InstallIn we specify in which component to provide these dependencies
* ViewModelComponent component scopes the dependencies to viewmodel's lifecycle
*/

@Module
@InstallIn(SingletonComponent::class)
object NetworkService {
    private val interceptor = HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)
    private val client = OkHttpClient.Builder().addInterceptor(interceptor).addInterceptor(Authenticator).build()
    private val retrofit = Retrofit.Builder().baseUrl("https://dummyapi.io/").client(client).addConverterFactory(MoshiConverterFactory.create()).build()

    @Provides
    @Singleton
    fun provideApi(): ApiEndpoints {
        return retrofit.create(ApiEndpoints::class.java)
    }
}