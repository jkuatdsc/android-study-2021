package com.example.android.dsc_android.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * An entity defines the format of the data to be stored in a database.
 */
@Entity(tableName = "student_table")
data class StudentData(
    @PrimaryKey(autoGenerate = true)
    var id:Long = 0L,
    @ColumnInfo(name = "name")
    var name:String,
    @ColumnInfo(name = "course")
    var course:String
)
