package com.tunc.androidpoetryapp.presentation.ui.login_signup

import android.content.Context
import androidx.lifecycle.MutableLiveData
import com.tunc.androidpoetryapp.R
import com.tunc.androidpoetryapp.base.BaseViewModel
import com.tunc.androidpoetryapp.data.model.request.LoginRequest
import com.tunc.androidpoetryapp.domain.entity.User
import com.tunc.androidpoetryapp.domain.usecases.AccountUseCase
import javax.inject.Inject

class FormViewModel @Inject constructor(
    private val accountUseCase: AccountUseCase,
    private val context: Context
) : BaseViewModel() {

    var user = MutableLiveData<User>()

    fun login(loginRequest: LoginRequest) {
        when {
            loginRequest.email.isNullOrEmpty() -> {
                showMessage.postValue(context.getString(R.string.warning_empty_login_email))
            }
            loginRequest.password.isNullOrEmpty() -> {
                showMessage.postValue(context.getString(R.string.warning_empty_login_password))
            }
            else -> {
                execute({ accountUseCase.login(loginRequest) },
                    result = {
                        user.value = it
                    })
            }
        }
    }
}