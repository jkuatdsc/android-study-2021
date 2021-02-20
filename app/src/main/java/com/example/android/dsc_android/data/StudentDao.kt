package com.example.android.dsc_android.data

import androidx.lifecycle.LiveData
import androidx.room.*

/**
 * Dao stands for Data Access Object
 * It is the interface containing methods we use to access the data in the database.
 */
@Dao
interface StudentDao {
    @Insert
    fun insert(vararg student:StudentData)

    @Update
    fun update(student: StudentData)

    @Delete
    fun delete(student: StudentData)

    @Query("DELETE from student_table")
    fun clear()

    /**
     * What is live data?
     * An observable data class that is lifecycle-aware.
     */
    @Query("SELECT * from student_table")
    fun observeAllStudentData():LiveData<List<StudentData>>

    @Query("SELECT * from student_table WHERE id LIKE :studentId")
    fun getStudentDataWithId(studentId:Long):StudentData

    @Query("SELECT * from student_table")
    fun getAllStudents():List<StudentData>
}