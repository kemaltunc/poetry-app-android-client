package com.tunc.androidpoetryapp.domain.usecases

import com.tunc.androidpoetryapp.domain.entity.Post
import com.tunc.androidpoetryapp.domain.mappers.toPost
import com.tunc.androidpoetryapp.domain.repository.PostRepository
import javax.inject.Inject

class PostUseCase @Inject constructor(private val postRepository: PostRepository) {

    suspend fun getPosts(page: Int): List<Post> {
        return postRepository.getPosts(page).map { it.toPost() }
    }

}