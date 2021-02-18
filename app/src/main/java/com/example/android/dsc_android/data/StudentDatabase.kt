package com.example.android.dsc_android.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

/**
 * Why does the database have to be an abstract class?
 * This is because RoomDatabase() from which it inherits, has defined methods thus it cannot be an
 * interface
 * And also it contains a function 'dao' which is yet to be implemented thus it cannot be a class
 */
@Database(entities = [StudentData::class], version = 1, exportSchema = false)
abstract class StudentDatabase : RoomDatabase() {
    abstract fun dao(): StudentDao

    companion object {
        /**
         * @Volatile is used to ensure all other threads are made aware of the instantiation of the
         * database.
         */
        @Volatile
        private var INSTANCE: StudentDatabase? = null
        fun initializeDatabase(context: Context): StudentDatabase {
            /**
             * Synchronized facilitates thread safety by ensuring only one thread can instantiate
             * the database.
             */
            synchronized(this) {
                var instance = INSTANCE
                if (instance == null) {
                    instance =
                        Room.databaseBuilder(context.applicationContext, StudentDatabase::class.java, "student_db")
                            .fallbackToDestructiveMigration().build()
                    INSTANCE = instance
                }
                return instance
            }
        }
    }
}