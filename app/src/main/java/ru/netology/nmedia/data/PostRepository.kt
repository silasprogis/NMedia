package ru.netology.nmedia.data

import androidx.lifecycle.LiveData
import ru.netology.nmedia.Post

interface PostRepository {

    //val data: LiveData<Post>
    fun getAll(): LiveData<List<Post>>
    fun likeById(id: Long)
    //fun share()
}