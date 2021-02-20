package com.example.android.dsc_android

import androidx.room.Room
import com.example.android.dsc_android.data.StudentDao
import com.example.android.dsc_android.data.StudentDatabase
import org.junit.runner.RunWith
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.platform.app.InstrumentationRegistry
import com.example.android.dsc_android.data.StudentData
import junit.framework.Assert.assertEquals
import kotlinx.coroutines.runBlocking
import org.junit.After
import org.junit.Before
import org.junit.Test

@RunWith(AndroidJUnit4::class)
class StudentDatabaseTest {
    private lateinit var database: StudentDatabase
    private lateinit var dao: StudentDao

    @Before
    fun createDb() {
        val context = InstrumentationRegistry.getInstrumentation().targetContext
        database = Room.inMemoryDatabaseBuilder(context, StudentDatabase::class.java)
            .allowMainThreadQueries().build()
        dao = database.dao()
    }
    @Test
    fun insertAndGetStudentData(){
        val student = StudentData(id = 1, name = "Raphael",course = "Computer Science")
        dao.insert(student)
        val studentList = runBlocking { dao.getAllStudents() }

        assert(studentList.contains(student))
    }
    @After
    fun closeDb(){
        database.close()
    }
}