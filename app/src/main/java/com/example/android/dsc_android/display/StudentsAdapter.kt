package com.example.android.dsc_android.display

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.android.dsc_android.data.StudentData
import com.example.android.dsc_android.databinding.ListItemStudentBinding

/**
 * What is an adapter?
 * Like the adapter that connects your laptop to the power source, this adapter connects the
 * UI component to the data source
 */
class StudentsAdapter() : ListAdapter<StudentData, StudentsAdapter.ViewHolder>(DiffUtilCallback) {
    class ViewHolder(private val binding: ListItemStudentBinding) :
        RecyclerView.ViewHolder(binding.root) {
            fun bind(currentStudent:StudentData){
                binding.studentName.text = currentStudent.name
                binding.studentCourse.text = currentStudent.course
            }

    }

    object DiffUtilCallback : DiffUtil.ItemCallback<StudentData>() {
        override fun areItemsTheSame(oldItem: StudentData, newItem: StudentData): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: StudentData, newItem: StudentData): Boolean {
            return oldItem == newItem
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = ListItemStudentBinding.inflate(layoutInflater,parent,false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val currentStudent = getItem(position)
        holder.bind(currentStudent)
    }
}