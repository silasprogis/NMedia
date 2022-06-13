package ru.netology.nmedia

data class Post(
    val id: Long,
    val author: String,
    val content: String,
    val published: String,
    val likesCount: Int,
    var shareCountValue: Int,
    val viewCountValue: Int,
    val likedByMe: Boolean = false
)
