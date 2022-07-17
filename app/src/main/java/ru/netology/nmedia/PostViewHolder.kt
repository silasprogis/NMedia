package ru.netology.nmedia

import android.widget.PopupMenu
import androidx.recyclerview.widget.RecyclerView
import ru.netology.nmedia.databinding.CardPostBinding

class PostViewHolder(
    private val binding: CardPostBinding,
    private val onLikeListener: OnLikeListener,
    private val onShareListener: OnShareListener,
    private val onRemoveListener: OnRemoveListener,
): RecyclerView.ViewHolder(binding.root) {
    fun bind(post: Post) {
        binding.apply {
            author.text = post.author
            published.text = post.published
            content.text = post.content
            likesCount.text = countConvert(post.likesCount)
            shareCount.text = countConvert(post.shareCountValue)
            viewCount.text = countConvert(post.viewCountValue)
            like.setImageResource(
                if (post.likedByMe) R.drawable.ic_liked_24 else R.drawable.ic_like_24
            )
            like.setOnClickListener {
                onLikeListener(post)
            }
            share.setOnClickListener{
                onShareListener(post)
            }
            menu.setOnClickListener {
                PopupMenu(it.context, it).apply {
                    inflate(R.menu.post_menu)

                    setOnMenuItemClickListener { menuItem ->
                        when (menuItem.itemId) {
                            R.id.remove -> {
                                onRemoveListener(post)
                                true
                            }
                            else -> false
                        }
                    }

                }
            }
        }
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