package com.tunc.androidpoetryapp.data.model.response


import com.squareup.moshi.Json


data class PostResponseItem(
    @Json(name = "createdAt")
    var createdAt: String?,
    @Json(name = "content")
    var content: String?,
    @Json(name = "_id")
    var _id: String?,
    @Json(name = "title")
    var title: String?,
    @Json(name = "updatedAt")
    var updatedAt: String?,
    @Json(name = "user")
    var user: UserResponse?
)