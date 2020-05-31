package com.tunc.androidpoetryapp.domain.mappers

import com.tunc.androidpoetryapp.data.model.response.PostResponseItem
import com.tunc.androidpoetryapp.domain.entity.Post

fun PostResponseItem.toPost() = Post(
    postId = this._id,
    title = this.title,
    content = this.content,
    createdAt = this.createdAt,
    user = this.user?.toUser(),
    isLiked = this.isLike,
    likeCount = this.likeCount,
    isFavorite = this.isFavorite
)