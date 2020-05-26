package com.tunc.androidpoetryapp.domain.usecases

import com.tunc.androidpoetryapp.data.model.request.LoginRequest
import com.tunc.androidpoetryapp.domain.entity.User
import com.tunc.androidpoetryapp.domain.mappers.toUser
import com.tunc.androidpoetryapp.domain.repository.AccountRepository
import javax.inject.Inject

class AccountUseCase @Inject constructor(private val accountRepository: AccountRepository) {

    suspend fun login(loginRequest: LoginRequest): User {

        val response = accountRepository.login(loginRequest)
        return response.user.toUser()
    }


    fun isLogin() = accountRepository.isLogined()
}