package ru.netology.nmedia

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import ru.netology.nmedia.databinding.ActivityMainBinding
import ru.netology.nmedia.databinding.CardPostBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val viewModel: PostViewModel by viewModels()
        val adapter = PostAdapter ({
            viewModel.likeById(it.id)
        },{
            viewModel.shareById(it.id)
        })
            
        binding.list.adapter = adapter
        viewModel.data.observe(this) { posts ->
            adapter.submitList(posts)
        }

        /*viewModel.data.observe(this) { posts ->
            binding.list.removeAllViews()
            posts.map { post ->
                CardPostBinding.inflate(layoutInflater, binding.list, true).apply {
                    author.text = post.author
                    published.text = post.published
                    content.text = post.content
                    likesCount.text = countConvert(post.likesCount)
                    shareCount.text = countConvert(post.shareCountValue)
                    viewCount.text = countConvert(post.viewCountValue)
                    like.setImageResource(
                        if (post.likedByMe) R.drawable.ic_liked_24 else R.drawable.ic_like_24
                    )
                    like?.setOnClickListener {
                        viewModel.likeById(post.id)
                    }
                }.root
            }
        }*/
    }


    fun countConvert(count: Int): String {
        val count = count
        var converted: String
        converted = count.toString()
        when (count) {
            in 0..999 -> converted = count.toString()
            in 1000..9999 -> if ((count % 1000) < 100) {
                converted = ((count / 1000).toString() + "K")
            } else {
                converted =
                    ((count / 1000).toString() + "," + ((count % 1000) / 100).toString() + "K")
            }
            in 10000..999999 -> converted = ((count / 1000).toString() + "K")
            in 1000000..Int.MAX_VALUE -> converted = ((count / 1000000).toString() + "M")
            }
        return converted
    }
}
