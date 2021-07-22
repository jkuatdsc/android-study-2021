package com.dscjkuat.hiltcode.presentation.main.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.Adapter
import com.bumptech.glide.Glide
import com.dscjkuat.hiltcode.databinding.DataItemBinding
import com.dscjkuat.hiltcode.domain.models.User

class UserListAdapter(val data: List<User>) : Adapter<UserListAdapter.UserViewHolder>() {

    class UserViewHolder(val binding: DataItemBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        return UserViewHolder(
            DataItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        val data = data[position]


        with(holder.binding) {
            title.text = data.title
            firstName.text = data.firstName
            lastName.text = data.lastName
            val context = root.context
            Glide.with(context).load(data.picture).into(picture)
        }
    }

    override fun getItemCount(): Int {
        return data.size
    }
}