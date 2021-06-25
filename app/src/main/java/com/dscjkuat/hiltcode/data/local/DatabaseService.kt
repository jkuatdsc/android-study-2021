package com.dscjkuat.hiltcode.data.local

import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseService {

    @Provides
    @Singleton
    fun provideDb(@ApplicationContext context: Context): HiltDatabase {
        return Room.databaseBuilder(context, HiltDatabase::class.java, "hilt_db")
            .fallbackToDestructiveMigration().build()
    }

    @Provides
    @Singleton
    fun provideDao(database: HiltDatabase): HiltDao = database.dao()
}