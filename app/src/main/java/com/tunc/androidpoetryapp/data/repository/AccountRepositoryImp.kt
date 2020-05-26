package com.tunc.androidpoetryapp.data.repository

import com.tunc.androidpoetryapp.data.local.PrefHelper
import com.tunc.androidpoetryapp.data.model.request.LoginRequest
import com.tunc.androidpoetryapp.data.model.response.LoginResponse
import com.tunc.androidpoetryapp.data.service.AccountServices
import com.tunc.androidpoetryapp.domain.repository.AccountRepository

class AccountRepositoryImp(
    private val accountServices: AccountServices,
    private val prefHelper: PrefHelper
) : AccountRepository {
    override suspend fun login(loginRequest: LoginRequest): LoginResponse {
        val response = accountServices.login(loginRequest)
        prefHelper.saveAuthorizationToken(response.token)
        return response
    }

    override fun isLogined(): Boolean {
        val token = prefHelper.getAuthorizationToken()
        return !token.isNullOrEmpty()
    }

}