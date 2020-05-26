package com.tunc.androidpoetryapp.di.modules

import android.app.Application
import android.content.Context
import com.facebook.stetho.okhttp3.StethoInterceptor
import com.readystatesoftware.chuck.ChuckInterceptor
import com.tunc.androidpoetryapp.BuildConfig
import com.tunc.androidpoetryapp.data.local.PrefHelper
import com.tunc.androidpoetryapp.util.CacheInterceptor
import com.tunc.androidpoetryapp.util.LoggingIterceptor
import com.tunc.androidpoetryapp.util.NetworkUtil.CACHE_SIZE
import com.tunc.androidpoetryapp.util.NetworkUtil.CONNECT_TIME_OUT
import com.tunc.androidpoetryapp.util.NetworkUtil.READ_TIME_OUT
import dagger.Module
import dagger.Provides
import okhttp3.Cache
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
class NetworkModule {
    @Provides
    @Singleton
    fun provideOkHttpClient(
        application: Application,
        context: Context,
        prefHelper: PrefHelper
    ): OkHttpClient =
        OkHttpClient.Builder()
            .readTimeout(READ_TIME_OUT, TimeUnit.SECONDS)
            .connectTimeout(CONNECT_TIME_OUT, TimeUnit.SECONDS)
            .cache(Cache(context.cacheDir, CACHE_SIZE))
            .addInterceptor(CacheInterceptor(context, prefHelper))
            .addInterceptor(LoggingIterceptor())
            .addNetworkInterceptor(StethoInterceptor())
            .addNetworkInterceptor(ChuckInterceptor(application))
            .build()


    @Provides
    @Singleton
    fun provideRetrofit(okHttpClient: OkHttpClient): Retrofit = Retrofit.Builder()
        .baseUrl(BuildConfig.BASE_URL)
        .client(okHttpClient)
        .addConverterFactory(MoshiConverterFactory.create()).build()

}