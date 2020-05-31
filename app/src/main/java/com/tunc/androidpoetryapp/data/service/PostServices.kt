package com.tunc.androidpoetryapp.data.service

import com.tunc.androidpoetryapp.data.model.request.PostId
import com.tunc.androidpoetryapp.data.model.request.PostRequest
import com.tunc.androidpoetryapp.data.model.response.PostResponseItem
import com.tunc.androidpoetryapp.data.model.response.Result
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query

interface PostServices {
    @GET("post/getAll")
    suspend fun getPosts(@Query("page") page: Int): List<PostResponseItem>

    @POST("post/like")
    suspend fun postLike(@Body postId: PostId): Result

    @POST("post/unlike")
    suspend fun postunLike(@Body postId: PostId): Result

    @POST("post/create")
    suspend fun postCreate(@Body postRequest: PostRequest): Result

    @POST("post/addFavoritePost")
    suspend fun addFavoritePost(@Body postId: PostId): Result

    @POST("post/removeFavoritePost")
    suspend fun removeFavoritePost(@Body postId: PostId): Result
}