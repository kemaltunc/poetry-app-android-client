package com.tunc.androidpoetryapp.di.modules

import android.app.Application
import android.content.Context
import com.tunc.androidpoetryapp.MainApplication
import com.tunc.androidpoetryapp.data.local.PrefHelper
import com.tunc.androidpoetryapp.data.local.PrefHelperImp
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class AppModule {

    @Provides
    @Singleton
    fun provideApplication(app: MainApplication): Application = app

    @Provides
    @Singleton
    fun provideApplicationContext(app: MainApplication): Context = app.applicationContext


    @Provides
    @Singleton
    fun provideSharedPref(context: Context): PrefHelper = PrefHelperImp(context)

}