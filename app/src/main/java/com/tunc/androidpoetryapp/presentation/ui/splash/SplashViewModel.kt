package com.tunc.androidpoetryapp.presentation.ui.splash

import androidx.lifecycle.MutableLiveData
import com.tunc.androidpoetryapp.base.BaseViewModel
import com.tunc.androidpoetryapp.domain.usecases.AccountUseCase
import com.tunc.androidpoetryapp.util.enums.StartFragment
import javax.inject.Inject

class SplashViewModel @Inject constructor(
    private val accountUseCase: AccountUseCase
) : BaseViewModel() {

    val startFragment = MutableLiveData<StartFragment>()

    fun startScreen() {
        if (accountUseCase.isLogin()) {
            startFragment.value = StartFragment.FRAGMENT_HOME
        } else {
            startFragment.value = StartFragment.FRAGMENT_LOGIN
        }
    }


}