package com.tunc.androidpoetryapp.domain.repository

import com.tunc.androidpoetryapp.data.model.request.LoginRequest
import com.tunc.androidpoetryapp.data.model.response.LoginResponse

interface AccountRepository {
    suspend fun login(loginRequest: LoginRequest): LoginResponse

    fun isLogined(): Boolean
}