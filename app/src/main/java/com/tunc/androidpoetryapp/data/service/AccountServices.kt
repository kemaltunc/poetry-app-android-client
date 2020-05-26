package com.tunc.androidpoetryapp.data.service

import com.tunc.androidpoetryapp.data.model.request.LoginRequest
import com.tunc.androidpoetryapp.data.model.response.LoginResponse
import retrofit2.http.Body
import retrofit2.http.POST

interface AccountServices {
    @POST("users/login")
    suspend fun login(@Body loginRequest: LoginRequest): LoginResponse
}