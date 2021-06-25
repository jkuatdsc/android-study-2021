package com.dscjkuat.hiltcode.domain.models

import androidx.room.Entity
import androidx.room.PrimaryKey

data class UsersResponse(
    val `data`: List<User>,
    val limit: Int,
    val offset: Int,
    val page: Int,
    val total: Int
)

@Entity
data class User(
    val email: String,
    val firstName: String,
    @PrimaryKey val id: String,
    val lastName: String,
    val picture: String,
    val title: String
)