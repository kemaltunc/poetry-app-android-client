package com.tunc.androidpoetryapp.di.modules

import com.tunc.androidpoetryapp.presentation.ui.create_post.CreatePostFragment
import com.tunc.androidpoetryapp.presentation.ui.home.HomeFragment
import com.tunc.androidpoetryapp.presentation.ui.login_signup.FormFragment
import com.tunc.androidpoetryapp.presentation.ui.login_signup.LoginSignupFragment
import com.tunc.androidpoetryapp.presentation.ui.post.PostFragment
import com.tunc.androidpoetryapp.presentation.ui.profile.ProfileFragment
import com.tunc.androidpoetryapp.presentation.ui.splash.SplashFragment
import com.tunc.androidpoetryapp.presentation.ui.tab.TabFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class FragmentInjector {

    @ContributesAndroidInjector
    abstract fun loginSignupFragmentInjector(): LoginSignupFragment

    @ContributesAndroidInjector
    abstract fun formFragmentInjector(): FormFragment

    @ContributesAndroidInjector
    abstract fun homeFragmentInjector(): HomeFragment

    @ContributesAndroidInjector
    abstract fun splashFragmentInjector(): SplashFragment


    @ContributesAndroidInjector
    abstract fun tabFragmentInjector(): TabFragment

    @ContributesAndroidInjector
    abstract fun profileFragmentInjector(): ProfileFragment

    @ContributesAndroidInjector
    abstract fun postFragmentInjector(): PostFragment

    @ContributesAndroidInjector
    abstract fun createPostInjector(): CreatePostFragment

}