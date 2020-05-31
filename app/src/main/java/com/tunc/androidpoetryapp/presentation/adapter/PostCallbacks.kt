package com.tunc.androidpoetryapp.presentation.adapter

import com.tunc.androidpoetryapp.domain.entity.Post

interface PostCallbacks {
    fun postLike(item: Post)
    fun sharePost(item: Post)
    fun favoritePost(item: Post)
}