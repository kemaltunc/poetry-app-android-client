package com.tunc.androidpoetryapp.presentation.ui.splash

import androidx.lifecycle.Observer
import com.tunc.androidpoetryapp.base.BaseFragment
import com.tunc.androidpoetryapp.customviews.FragmentView.Companion.controller
import com.tunc.androidpoetryapp.databinding.FragmentSplashBinding
import com.tunc.androidpoetryapp.presentation.ui.login_signup.LoginSignupFragment
import com.tunc.androidpoetryapp.presentation.ui.tab.TabFragment
import com.tunc.androidpoetryapp.util.enums.StartFragment


class SplashFragment : BaseFragment<SplashViewModel, FragmentSplashBinding>() {

    override val classViewModel: Class<SplashViewModel> = SplashViewModel::class.java

    override fun setBinding() {
        binding = FragmentSplashBinding.inflate(layoutInflater)
    }

    override fun initUI() {
        viewModel.startScreen()
    }

    override fun subscribeObservers() {
        viewModel.startFragment.observe(viewLifecycleOwner, Observer {
            if (it == StartFragment.FRAGMENT_HOME) {
                controller.navigate(TabFragment.newInstance(), noHistory = true)
            } else {
                controller.navigate(LoginSignupFragment.newInstance(), noHistory = true)
            }
        })
    }


    companion object {
        fun newInstance() = SplashFragment()
    }
}
