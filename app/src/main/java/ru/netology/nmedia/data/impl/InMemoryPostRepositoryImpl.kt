package ru.netology.nmedia.data.impl

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import ru.netology.nmedia.data.PostRepository
import ru.netology.nmedia.Post

class InMemoryPostRepositoryImpl : PostRepository {


    private var posts = listOf(
        Post(
        1,
        "Нетология. Университет интернет-профессий будущего",
        "Привет, это новая Нетология! Когда-то Нетология начиналась с интенсивов по онлайн-маркетингу. Затем появились курсы по дизайну, разработке, аналитике и управлению. Мы растём сами и помогаем расти студентам: от новичков до уверенных профессионалов. Но самое важное остаётся с нами: мы верим, что в каждом уже есть сила, которая заставляет хотеть больше, целиться выше, бежать быстрее. Наша миссия — помочь встать на путь роста и начать цепочку перемен → http://netolo.gy/fyb",
        "26 мая в 18:00",
        999,
        998,
        997,
        false
        ),
        Post(
            2,
        "Нетология. Университет интернет-профессий будущего",
        "Привет, это новая Нетология! Когда-то Нетология начиналась с интенсивов по онлайн-маркетингу. Затем появились курсы по дизайну, разработке, аналитике и управлению. Мы растём сами и помогаем расти студентам: от новичков до уверенных профессионалов. Но самое важное остаётся с нами: мы верим, что в каждом уже есть сила, которая заставляет хотеть больше, целиться выше, бежать быстрее. Наша миссия — помочь встать на путь роста и начать цепочку перемен → http://netolo.gy/fyb",
        "26 мая в 18:00",
        19,
        8,
        97,
        false
        )
    )

    private val data = MutableLiveData(posts)

    override fun getAll(): LiveData<List<Post>> = data
    override fun likeById(id: Long) {
        posts = posts.map {
        if (it.id != id) it else {
            if (it.likedByMe) it.copy(likedByMe = !it.likedByMe, likesCount = it.likesCount - 1) else {
                it.copy(likedByMe = !it.likedByMe, likesCount = it.likesCount + 1)
            }
        }
    }
    data.value = posts
}

    override fun shareById(id: Long) {
        posts = posts.map {
            if (it.id != id) it else it.copy(shareCountValue = it.shareCountValue + 1)
        }
        data.value = posts
    }

 /*   override fun share() {
        post = post.copy(shareCountValue = post.shareCountValue + 1)
        data.value = post
    }*/
}