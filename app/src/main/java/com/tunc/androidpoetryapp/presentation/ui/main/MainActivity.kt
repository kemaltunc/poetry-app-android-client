package com.tunc.androidpoetryapp.presentation.ui.main

import android.os.Bundle
import com.tunc.androidpoetryapp.R
import com.tunc.androidpoetryapp.base.BaseActivity

class MainActivity : BaseActivity<MainViewModel>() {

    override val classViewModel: Class<MainViewModel> = MainViewModel::class.java

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        /* val binding = ActivityMainBinding.inflate(layoutInflater)*/
        setContentView(R.layout.activity_main)
    }
}
