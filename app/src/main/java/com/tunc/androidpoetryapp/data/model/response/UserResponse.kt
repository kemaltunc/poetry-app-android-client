package com.tunc.androidpoetryapp.data.model.response

import com.squareup.moshi.Json

data class UserResponse(
    @field:Json(name = "_id") var id: String,
    var name: String? = null,
    var surname: String? = null,
    var email: String? = null
)