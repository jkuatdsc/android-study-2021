package com.dscjkuat.hiltcode.domain.models

data class UsersResponse(
    val `data`: List<User>,
    val limit: Int,
    val offset: Int,
    val page: Int,
    val total: Int
)

data class User(
    val email: String,
    val firstName: String,
    val id: String,
    val lastName: String,
    val picture: String,
    val title: String
)