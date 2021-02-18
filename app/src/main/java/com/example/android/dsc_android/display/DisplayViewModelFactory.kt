package com.example.android.dsc_android.display

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.android.dsc_android.data.StudentDao

class DisplayViewModelFactory(private val dao:StudentDao):ViewModelProvider.NewInstanceFactory() {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return DisplayViewModel(dao) as T
    }
}