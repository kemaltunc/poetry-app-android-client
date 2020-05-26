package com.tunc.androidpoetryapp.presentation.adapter

import android.view.ViewGroup
import com.tunc.androidpoetryapp.R
import com.tunc.androidpoetryapp.base.BaseAdapter
import com.tunc.androidpoetryapp.base.BaseViewHolder
import com.tunc.androidpoetryapp.databinding.CellPostItemBinding
import com.tunc.androidpoetryapp.domain.entity.Post


class PostAdapter(private val postCallbacks: PostCallbacks) :
    BaseAdapter<Post, BaseViewHolder<Post>>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder<Post> {
        return PostViewHolder(parent, postCallbacks)
    }


    class PostViewHolder(
        parent: ViewGroup,
        private val postCallbacks: PostCallbacks
    ) : BaseViewHolder<Post>(parent, LAYOUT_ID) {

        val binding: CellPostItemBinding = CellPostItemBinding.bind(itemView)
        override fun bind(item: Post) {
            with(binding) {

                item.user?.let {
                    userName.text = it.fullName
                }
                postDate.text = item.createdAt
                postTitle.text = item.title
                postContent.text = item.content


                likeButton.setOnClickListener {
                    postCallbacks.postLike(item)
                }
            }
        }

        companion object {
            const val LAYOUT_ID = R.layout.cell_post_item

        }


    }


}
