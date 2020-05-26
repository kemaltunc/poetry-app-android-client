package com.tunc.androidpoetryapp.data.model.response

data class LoginResponse(
    var token: String,
    var user: UserResponse
)