package com.example.android.dsc_android.display

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.example.android.dsc_android.R
import com.example.android.dsc_android.data.StudentDao
import com.example.android.dsc_android.data.StudentData
import com.example.android.dsc_android.data.StudentDatabase
import com.example.android.dsc_android.databinding.DisplayFragmentBinding

class DisplayFragment : Fragment() {

    companion object {
        fun newInstance() = DisplayFragment()
    }

    /**
     * A view model is a class connected to a fragment or activity that contains all the logic
     * and data interactions.
     * Why is this necessary?
     */
    private lateinit var viewModel: DisplayViewModel

    /**
     * View binding is whereby android generates a class containing all the views at compile time.
     * Why is this necessary?
     */
    private lateinit var binding: DisplayFragmentBinding
    private lateinit var dao: StudentDao

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DisplayFragmentBinding.inflate(inflater, container, false)
        dao = StudentDatabase.initializeDatabase(requireContext()).dao()
        viewModel =
            ViewModelProvider(this, DisplayViewModelFactory(dao)).get(DisplayViewModel::class.java)

        val adapter = StudentsAdapter()
        viewModel.studentList.observe(viewLifecycleOwner, Observer {
            adapter.submitList(it)
        })
        binding.recyclerView.adapter = adapter

        binding.fab.setOnClickListener {
            Log.i("DisplayFragment", "fab has been clicked")
            findNavController().navigate(DisplayFragmentDirections.actionDisplayFragmentToInputFragment())
        }

        return binding.root
    }

}