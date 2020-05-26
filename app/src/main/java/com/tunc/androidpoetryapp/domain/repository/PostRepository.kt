package com.tunc.androidpoetryapp.domain.repository

import com.tunc.androidpoetryapp.data.model.response.PostResponseItem

interface PostRepository {

    suspend fun getPosts(page: Int): List<PostResponseItem>
}