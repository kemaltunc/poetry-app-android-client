package com.tunc.androidpoetryapp.di.modules

import com.tunc.androidpoetryapp.presentation.ui.main.MainActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityInjector {

    @ContributesAndroidInjector
    abstract fun mainActivityInjector(): MainActivity

}