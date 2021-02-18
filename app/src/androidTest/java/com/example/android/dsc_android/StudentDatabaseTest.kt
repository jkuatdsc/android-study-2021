package com.example.android.dsc_android

import androidx.room.Room
import com.example.android.dsc_android.data.StudentDao
import com.example.android.dsc_android.data.StudentDatabase
import org.junit.runner.RunWith
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.platform.app.InstrumentationRegistry
import com.example.android.dsc_android.data.StudentData
import junit.framework.Assert.assertEquals
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
        database = Room.databaseBuilder(context, StudentDatabase::class.java, "student_db")
            .allowMainThreadQueries().build()
        dao = database.dao()
    }
    @Test
    fun insertAndGetStudentData(){
        val student = StudentData(name = "Raphael",course = "Computer Science")
        dao.insert(student)
        val student2 = dao.getStudentDataWithId(student.id)

        assertEquals(student,student2)
    }
    @After
    fun closeDb(){
        database.close()
    }
}