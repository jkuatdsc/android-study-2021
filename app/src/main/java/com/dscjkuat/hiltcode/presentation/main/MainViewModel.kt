package com.dscjkuat.hiltcode.presentation.main

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.dscjkuat.hiltcode.domain.repository.HiltRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(private val repository: HiltRepository): ViewModel() {

    val users = repository.users
    fun getUsers() {
        viewModelScope.launch {
            val users = repository.getUsers(10)
            Log.d("MainViewModel", "getUsers: $users")
        }
    }
}