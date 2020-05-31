package com.tunc.androidpoetryapp.di.modules

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.tunc.androidpoetryapp.di.ViewModelFactory
import com.tunc.androidpoetryapp.di.ViewModelKey
import com.tunc.androidpoetryapp.presentation.ui.create_post.CreatePostViewModel
import com.tunc.androidpoetryapp.presentation.ui.home.HomeViewModel
import com.tunc.androidpoetryapp.presentation.ui.login_signup.FormViewModel
import com.tunc.androidpoetryapp.presentation.ui.login_signup.LoginSignupViewModel
import com.tunc.androidpoetryapp.presentation.ui.main.MainViewModel
import com.tunc.androidpoetryapp.presentation.ui.post.PostViewModel
import com.tunc.androidpoetryapp.presentation.ui.profile.ProfileViewModel
import com.tunc.androidpoetryapp.presentation.ui.splash.SplashViewModel
import com.tunc.androidpoetryapp.presentation.ui.tab.TabvViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class ViewModule {
    @Binds
    internal abstract fun bindViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory

    @Binds
    @IntoMap
    @ViewModelKey(MainViewModel::class)
    internal abstract fun mainViewModel(viewModel: MainViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(LoginSignupViewModel::class)
    internal abstract fun loginSignupViewModel(viewModel: LoginSignupViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(FormViewModel::class)
    internal abstract fun formViewModel(viewModel: FormViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(HomeViewModel::class)
    internal abstract fun homeViewModel(viewModel: HomeViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(SplashViewModel::class)
    internal abstract fun splashViewModel(viewModel: SplashViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(TabvViewModel::class)
    internal abstract fun tabViewModel(viewModel: TabvViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(ProfileViewModel::class)
    internal abstract fun profileViewModel(viewModel: ProfileViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(PostViewModel::class)
    internal abstract fun postViewModel(viewModel: PostViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(CreatePostViewModel::class)
    internal abstract fun createPostViewModel(viewModel: CreatePostViewModel): ViewModel
}