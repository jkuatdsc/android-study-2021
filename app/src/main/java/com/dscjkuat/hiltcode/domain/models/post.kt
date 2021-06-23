package com.dscjkuat.hiltcode.domain.models

data class PostResponse(
    val `data`: List<Post>,
    val limit: Int,
    val offset: Int,
    val page: Int,
    val total: Int
)

data class Post(
    val id: String,
    val image: String,
    val likes: Int,
    val link: Any,
    val owner: Owner,
    val publishDate: String,
    val tags: List<String>,
    val text: String
)

data class Owner(
    val email: String,
    val firstName: String,
    val id: String,
    val lastName: String,
    val picture: String,
    val title: String
)