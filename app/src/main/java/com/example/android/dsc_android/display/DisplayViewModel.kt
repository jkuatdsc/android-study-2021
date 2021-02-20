package com.example.android.dsc_android.display

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.android.dsc_android.data.StudentDao
import com.example.android.dsc_android.data.StudentData

class DisplayViewModel(dao: StudentDao) : ViewModel() {
    val studentList = dao.observeAllStudentData()
}