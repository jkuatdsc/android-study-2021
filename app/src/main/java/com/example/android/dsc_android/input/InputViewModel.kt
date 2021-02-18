package com.example.android.dsc_android.input

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.android.dsc_android.data.StudentDao
import com.example.android.dsc_android.data.StudentData
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class InputViewModel(private val dao: StudentDao) : ViewModel() {

    fun saveStudentData(studentName: String, studentCourse: String) {
        viewModelScope.launch {
            withContext(Dispatchers.IO){
                val student = StudentData(name = studentName, course = studentCourse)
                dao.insert(student)
                Log.i("InputViewModel","The student has been saved")
            }
        }
    }
}