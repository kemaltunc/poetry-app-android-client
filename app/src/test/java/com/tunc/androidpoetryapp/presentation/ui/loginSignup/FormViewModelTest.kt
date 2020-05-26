package com.tunc.androidpoetryapp.presentation.ui.loginSignup

import android.content.Context
import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.Observer
import com.google.common.truth.Truth
import com.tunc.androidpoetryapp.data.model.request.LoginRequest
import com.tunc.androidpoetryapp.domain.entity.User
import com.tunc.androidpoetryapp.domain.usecases.AccountUseCase
import com.tunc.androidpoetryapp.presentation.ui.login_signup.FormViewModel
import io.mockk.*
import io.mockk.impl.annotations.MockK
import kotlinx.coroutines.*
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.setMain
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class FormViewModelTest {

    @ObsoleteCoroutinesApi
    private val mainThreadSurrogate = newSingleThreadContext("UI thread")


    @Rule
    @JvmField
    val instantExecutorRule = InstantTaskExecutorRule()

    @MockK
    lateinit var accountUseCase: AccountUseCase

    private lateinit var viewModel: FormViewModel

    @MockK
    lateinit var context: Context


    @ExperimentalCoroutinesApi
    @Before
    fun setup() {
        MockKAnnotations.init(this)
        Dispatchers.setMain(mainThreadSurrogate)
        viewModel = FormViewModel(accountUseCase, context)

    }

    @ObsoleteCoroutinesApi
    @ExperimentalCoroutinesApi
    @After
    fun tearDown() {
        Dispatchers.resetMain() // reset main dispatcher to the original Main dispatcher
        mainThreadSurrogate.close()
    }


    @Test
    fun `given login call made, when a successful use case returns, then adding observer emits onChanged`() {

        val loginRequest = LoginRequest("kk@gmail.com", "1")
        val mockUser = User("123", "kemal", "kemal@gmail.com")

        val observer: Observer<User> = mockk(relaxUnitFun = true)
        viewModel.user.observeForever(observer)

        runBlocking {
            launch(Dispatchers.IO) {

                every {
                    runBlocking {
                        accountUseCase.login(loginRequest)
                    }
                } returns (mockUser)

                viewModel.login(loginRequest)

                val slot = slot<User>()
                verify { observer.onChanged(capture(slot)) }

                val user = slot.captured

                Truth.assertThat(user.userId).isEqualTo("123")
                Truth.assertThat(user.name).isEqualTo("kemal")
                Truth.assertThat(user.email).isEqualTo("kemal@gmail.com")
            }
        }
    }
}

