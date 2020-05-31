package com.tunc.androidpoetryapp.presentation.adapter

import android.view.ViewGroup
import com.tunc.androidpoetryapp.R
import com.tunc.androidpoetryapp.base.BaseAdapter
import com.tunc.androidpoetryapp.base.BaseViewHolder
import com.tunc.androidpoetryapp.databinding.CellPostItemBinding
import com.tunc.androidpoetryapp.domain.entity.Post


class PostAdapter(private val postCallbacks: PostCallbacks) : BaseAdapter<Post>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder<Post, *> {
        if (viewType == LoadingHolder.LAYOUT_ID) {
            return LoadingHolder(parent) as BaseViewHolder<Post, *>
        }
        return PostViewHolder(parent, postCallbacks)
    }

    class PostViewHolder(
        parent: ViewGroup,
        private val postCallbacks: PostCallbacks
    ) : BaseViewHolder<Post, CellPostItemBinding>(parent, LAYOUT_ID) {
        override fun bind(item: Post, binding: CellPostItemBinding) {
            with(binding) {
                data = item
                likeButton.setOnClickListener {
                    item.isLiked = !item.isLiked
                    likeButton.setImg(
                        if (item.isLiked) context.getDrawable(R.drawable.ic_like) else context.getDrawable(
                            R.drawable.ic_unlike
                        )
                    )

                    likeButton.setCount(if (item.isLiked) (++item.likeCount) else (--item.likeCount))
                    postCallbacks.postLike(item)
                }

                shareButton.setOnClickListener {
                    postCallbacks.sharePost(item)
                }

                favoriteButton.setOnClickListener {
                    item.isFavorite = !item.isFavorite
                    favoriteButton.setImg(
                        if (item.isFavorite) context.getDrawable(R.drawable.ic_bookmork) else context.getDrawable(
                            R.drawable.ic_unbookmark
                        )
                    )
                    postCallbacks.favoritePost(item)
                }
                executePendingBindings()
            }
        }


        companion object {
            const val LAYOUT_ID = R.layout.cell_post_item
        }

    }
}


