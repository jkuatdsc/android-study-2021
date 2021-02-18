package com.example.android.dsc_android.input

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.android.dsc_android.data.StudentDao

/**
 * Why do we need a ViewModelFactory?
 * As you can see from the previous ViewModel configuration, there is no way of passing arguments
 * to the constructor of the viewmodel.
 * A viewModelFactory creates a new instance of the viewmodel and passes the required arguments.
 */
class InputViewModelFactory(private val dao:StudentDao):ViewModelProvider.NewInstanceFactory() {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return InputViewModel(dao) as T
    }
}