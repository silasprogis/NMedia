package ru.netology.nmedia

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import ru.netology.nmedia.data.PostRepository
import ru.netology.nmedia.data.impl.InMemoryPostRepositoryImpl

private val empty = Post(
    0L,
    "",
    "",
    "",
    100,
    50,
    150,
    false
)

class PostViewModel : ViewModel() {
    private val repository: PostRepository = InMemoryPostRepositoryImpl()
    val data = repository.getAll()
    val edited = MutableLiveData(empty)
    fun likeById(id: Long) = repository.likeById(id)
    fun shareById(id: Long) = repository.shareById(id)
    fun removeById(id: Long) = repository.removeById(id)

    fun changeContent(content: String) {
        if (content.isBlank()) {
            return
        }
        edited.value?.let {
            edited.value = it.copy(content = content)
        }

    }
    fun save() {
        edited.value?.let {
            repository.save(it)
            edited.value = empty
        }
    }
}