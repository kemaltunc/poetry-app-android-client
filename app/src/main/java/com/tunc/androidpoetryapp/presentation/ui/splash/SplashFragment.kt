package com.tunc.androidpoetryapp.presentation.ui.splash

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.lifecycle.Observer
import com.tunc.androidpoetryapp.R
import com.tunc.androidpoetryapp.base.BaseFragment
import com.tunc.androidpoetryapp.databinding.FragmentSplashBinding
import com.tunc.androidpoetryapp.util.enums.StartFragment
import com.tunc.androidpoetryapp.util.extension.safeController


class SplashFragment : BaseFragment<SplashViewModel, FragmentSplashBinding>() {

    override val layoutRes: Int = R.layout.fragment_splash
    override val classViewModel: Class<SplashViewModel> = SplashViewModel::class.java


    override fun initUI() {
        viewModel.startScreen()
    }

    override fun subscribeObservers() {
        viewModel.startFragment.observe(viewLifecycleOwner, Observer {
            if (it == StartFragment.FRAGMENT_HOME) {
                safeController()?.navigate(R.id.action_splashFragment_to_tabFragment)
            } else {
                safeController()?.navigate(R.id.action_splashFragment_to_loginSignupFragment)
            }
        })
    }


    companion object {
        fun newInstance() = SplashFragment()
    }
}
