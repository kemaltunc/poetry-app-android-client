package com.tunc.androidpoetryapp.domain.mappers

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.google.common.truth.Truth
import com.tunc.androidpoetryapp.data.model.request.LoginRequest
import com.tunc.androidpoetryapp.data.model.response.LoginResponse
import com.tunc.androidpoetryapp.data.model.response.UserResponse
import com.tunc.androidpoetryapp.domain.repository.AccountRepository
import io.mockk.MockKAnnotations
import io.mockk.every
import io.mockk.impl.annotations.MockK
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class AccountMappersTest {

    private lateinit var loginResponse: LoginResponse

    @Rule
    @JvmField
    val instantExecutorRule = InstantTaskExecutorRule()

    @MockK
    lateinit var accountRepository: AccountRepository

    @Before
    fun setup() {
        MockKAnnotations.init(this)
    }

    @Test
    fun `Datanın null gelmediği durumda mapleme`() {

        val loginRequest = LoginRequest("kk@gmail.com", "1")


        loginResponse = LoginResponse(
            "123",
            user = UserResponse(
                "123",
                "kemal",
                "kemal@gmail.com"
            )
        )
        every { runBlocking { accountRepository.login(loginRequest) } } returns loginResponse

        val user = loginResponse.toUser()

        Truth.assertThat(user.userId).isEqualTo("123")
        Truth.assertThat(user.name).isEqualTo("kemal")
        Truth.assertThat(user.email).isEqualTo("kemal@gmail.com")

    }

}