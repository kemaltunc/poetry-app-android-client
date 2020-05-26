package com.tunc.androidpoetryapp.domain.entity

import com.tunc.androidpoetryapp.data.model.response.UserResponse

data class Post(
    var postId: String? = "",
    var title: String? = "",
    var content: String? = "",
    var createdAt: String? = "",
    var user: User? = null
)