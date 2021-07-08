package com.dscjkuat.hiltcode.domain.models

import androidx.room.Entity
import androidx.room.PrimaryKey

data class PostResponse(
    val `data`: List<Post>,
    val limit: Int,
    val offset: Int,
    val page: Int,
    val total: Int
)

@Entity
data class Post(
    @PrimaryKey val id: String,
    val image: String,
    val likes: Int,
    val link: String?,
    val owner: User,
    val publishDate: String,
    val tags: List<String>,
    val text: String
)

