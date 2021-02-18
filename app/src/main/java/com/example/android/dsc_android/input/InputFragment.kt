package com.example.android.dsc_android.input

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.android.dsc_android.R
import com.example.android.dsc_android.data.StudentDao
import com.example.android.dsc_android.data.StudentDatabase
import com.example.android.dsc_android.databinding.InputFragmentBinding
import com.example.android.dsc_android.display.StudentsAdapter

class InputFragment : Fragment() {

    companion object {
        fun newInstance() = InputFragment()
    }

    private lateinit var viewModel: InputViewModel
    private lateinit var binding: InputFragmentBinding
    private lateinit var dao: StudentDao


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = InputFragmentBinding.inflate(inflater, container, false)
        dao = StudentDatabase.initializeDatabase(requireContext()).dao()
        viewModel =
            ViewModelProvider(this, InputViewModelFactory(dao)).get(InputViewModel::class.java)

        binding.saveButton.setOnClickListener {
            val studentName = binding.studentName.text.toString()
            val studentCourse = binding.studentCourse.text.toString()
            Log.i("InputFragment","The student data is $studentName $studentCourse")
            if (studentName.isNullOrBlank() || studentCourse.isNullOrBlank()) {
                return@setOnClickListener
            }
            viewModel.saveStudentData(studentName, studentCourse)
            findNavController().navigate(InputFragmentDirections.actionInputFragmentToDisplayFragment())
        }

        return binding.root
    }
}