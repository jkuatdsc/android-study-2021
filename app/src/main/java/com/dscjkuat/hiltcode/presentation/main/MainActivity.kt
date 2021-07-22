package com.dscjkuat.hiltcode.presentation.main

import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.dscjkuat.hiltcode.databinding.ActivityMainBinding
import com.dscjkuat.hiltcode.presentation.main.adapter.UserListAdapter
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private val viewModel: MainViewModel by viewModels()
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel.getUsers()
        lifecycleScope.launch {
            viewModel.users.collect {
                binding.mainRecyclerview.adapter = UserListAdapter(it)
                Log.d("MainActivity", "onCreate: $it")
            }
        }
    }
}