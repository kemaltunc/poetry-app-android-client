package com.tunc.androidpoetryapp.di.component

import com.tunc.androidpoetryapp.MainApplication
import com.tunc.androidpoetryapp.di.modules.*
import dagger.BindsInstance
import dagger.Component
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        AndroidSupportInjectionModule::class,
        AppModule::class,
        ViewModule::class,
        ActivityInjector::class,
        FragmentInjector::class,
        NetworkModule::class,
        ServiceModule::class
    ]
)
interface AppComponent {
    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(mainApplication: MainApplication): Builder


        fun build(): AppComponent

    }

    fun inject(mainApplication: MainApplication)
}