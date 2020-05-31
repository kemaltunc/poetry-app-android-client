package com.tunc.androidpoetryapp.domain.usecases

import com.tunc.androidpoetryapp.data.model.request.PostId
import com.tunc.androidpoetryapp.data.model.request.PostRequest
import com.tunc.androidpoetryapp.domain.entity.Post
import com.tunc.androidpoetryapp.domain.mappers.toPost
import com.tunc.androidpoetryapp.domain.repository.PostRepository
import javax.inject.Inject

class PostUseCase @Inject constructor(private val postRepository: PostRepository) {

    suspend fun getPosts(page: Int): List<Post> {
        return postRepository.getPosts(page).map { it.toPost() }
    }

    suspend fun postLike(postId: PostId): Boolean {
        return postRepository.postLike(postId).result
    }

    suspend fun postunLike(postId: PostId): Boolean {
        return postRepository.postunLike(postId).result
    }

    suspend fun createPost(postRequest: PostRequest): Boolean {
        return postRepository.createPost(postRequest).result
    }

    suspend fun addFavoritePost(postId: PostId): Boolean {
        return postRepository.addFavoritePost(postId).result
    }

    suspend fun removeFavoritePost(postId: PostId): Boolean {
        return postRepository.removeFavoritePost(postId).result
    }
}