package com.example.android.dsc_android.display

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.android.dsc_android.R
import com.example.android.dsc_android.databinding.DisplayFragmentBinding

class DisplayFragment : Fragment() {

    companion object {
        fun newInstance() = DisplayFragment()
    }

    private lateinit var viewModel: DisplayViewModel
    private lateinit var binding:DisplayFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DisplayFragmentBinding.inflate(inflater,container,false)

        binding.fab.setOnClickListener {
            Log.i("DisplayFragment","fab has been clicked")
            findNavController().navigate(DisplayFragmentDirections.actionDisplayFragmentToInputFragment())
        }

        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(DisplayViewModel::class.java)
        // TODO: Use the ViewModel
    }

}