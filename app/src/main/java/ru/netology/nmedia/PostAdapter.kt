package ru.netology.nmedia

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import ru.netology.nmedia.databinding.CardPostBinding

typealias OnLikeListener = (post: Post) -> Unit
typealias OnShareListener = (post: Post) -> Unit
typealias OnRemoveListener = (post: Post) -> Unit


class PostAdapter(
    private val onLikeListener: OnLikeListener,
    private val onShareListener: OnShareListener,
    private val onRemoveListener: OnRemoveListener,
    ) : ListAdapter<Post, PostViewHolder>(PostDiffCallback()) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostViewHolder {
        val binding = CardPostBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return PostViewHolder(binding, onLikeListener, onShareListener, onRemoveListener)
    }
    override fun onBindViewHolder(holder: PostViewHolder, position: Int) {
        val post = getItem(position)
        holder.bind(post)
    }
}