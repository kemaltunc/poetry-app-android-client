package com.tunc.androidpoetryapp.domain.repository

import com.tunc.androidpoetryapp.data.model.request.PostId
import com.tunc.androidpoetryapp.data.model.request.PostRequest
import com.tunc.androidpoetryapp.data.model.response.PostResponseItem
import com.tunc.androidpoetryapp.data.model.response.Result

interface PostRepository {

    suspend fun getPosts(page: Int): List<PostResponseItem>
    suspend fun postLike(postId: PostId): Result
    suspend fun postunLike(postId: PostId): Result
    suspend fun createPost(postRequest: PostRequest): Result
    suspend fun addFavoritePost(postId: PostId): Result
    suspend fun removeFavoritePost(postId: PostId): Result
}