package com.tunc.androidpoetryapp.data.repository

import com.tunc.androidpoetryapp.data.model.response.PostResponseItem
import com.tunc.androidpoetryapp.data.service.PostServices
import com.tunc.androidpoetryapp.domain.repository.PostRepository

class PostRepositoryImp(private val postServices: PostServices) : PostRepository {
    override suspend fun getPosts(page: Int): List<PostResponseItem> {
        return postServices.getPosts(page)
    }

}