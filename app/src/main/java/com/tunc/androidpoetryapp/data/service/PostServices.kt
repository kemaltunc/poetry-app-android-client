package com.tunc.androidpoetryapp.data.service

import com.tunc.androidpoetryapp.data.model.response.PostResponseItem
import retrofit2.http.GET
import retrofit2.http.Query

interface PostServices {
    @GET("post/getAll")
    suspend fun getPosts(@Query("page") page: Int): List<PostResponseItem>
}