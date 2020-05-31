package com.tunc.androidpoetryapp.data.repository

import com.tunc.androidpoetryapp.data.model.request.PostId
import com.tunc.androidpoetryapp.data.model.request.PostRequest
import com.tunc.androidpoetryapp.data.model.response.PostResponseItem
import com.tunc.androidpoetryapp.data.model.response.Result
import com.tunc.androidpoetryapp.data.service.PostServices
import com.tunc.androidpoetryapp.domain.repository.PostRepository

class PostRepositoryImp(private val postServices: PostServices) : PostRepository {
    override suspend fun getPosts(page: Int): List<PostResponseItem> {
        return postServices.getPosts(page)
    }

    override suspend fun postLike(postId: PostId): Result {
        return postServices.postLike(postId)
    }

    override suspend fun postunLike(postId: PostId): Result {
        return postServices.postunLike(postId)
    }

    override suspend fun createPost(postRequest: PostRequest): Result {
        return postServices.postCreate(postRequest)
    }

    override suspend fun addFavoritePost(postId: PostId): Result {
        return postServices.addFavoritePost(postId)
    }

    override suspend fun removeFavoritePost(postId: PostId): Result {
        return postServices.removeFavoritePost(postId)
    }
}