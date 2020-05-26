package com.tunc.androidpoetryapp.presentation.ui.main

import android.os.Bundle
import com.tunc.androidpoetryapp.base.BaseActivity
import com.tunc.androidpoetryapp.databinding.ActivityMainBinding
import com.tunc.androidpoetryapp.presentation.ui.splash.SplashFragment

class MainActivity : BaseActivity<MainViewModel>() {

    override val classViewModel: Class<MainViewModel> = MainViewModel::class.java

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.fragmentView.bind(this)
        binding.fragmentView.navigate(SplashFragment.newInstance())
    }
}
