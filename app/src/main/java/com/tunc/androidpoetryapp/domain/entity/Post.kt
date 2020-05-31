package com.tunc.androidpoetryapp.domain.entity

import com.tunc.androidpoetryapp.base.BaseEntity

data class Post(
    var postId: String = "",
    var title: String? = "",
    var content: String? = "",
    var createdAt: String? = "",
    var user: User? = null,
    var isLiked: Boolean = false,
    var likeCount: Int = 0,
    var isFavorite: Boolean = false
) : BaseEntity(compareId = postId)