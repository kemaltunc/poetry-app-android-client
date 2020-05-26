package com.tunc.androidpoetryapp.di.modules

import com.tunc.androidpoetryapp.data.local.PrefHelper
import com.tunc.androidpoetryapp.data.repository.AccountRepositoryImp
import com.tunc.androidpoetryapp.data.repository.PostRepositoryImp
import com.tunc.androidpoetryapp.data.service.AccountServices
import com.tunc.androidpoetryapp.data.service.PostServices
import com.tunc.androidpoetryapp.domain.repository.AccountRepository
import com.tunc.androidpoetryapp.domain.repository.PostRepository
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
class ServiceModule {
    @Singleton
    @Provides
    fun provideAccountService(retrofit: Retrofit): AccountServices =
        retrofit.create(AccountServices::class.java)

    @Singleton
    @Provides
    fun providePostService(retrofit: Retrofit): PostServices =
        retrofit.create(PostServices::class.java)

    @Singleton
    @Provides
    fun provideAccountRepository(
        accountServices: AccountServices,
        prefHelper: PrefHelper
    ): AccountRepository =
        AccountRepositoryImp(accountServices, prefHelper)

    @Singleton
    @Provides
    fun providePostRepository(
        postServices: PostServices
    ): PostRepository =
        PostRepositoryImp(postServices)
}