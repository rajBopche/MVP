package com.playground.dagger

import com.playground.network.ApiManager
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class NetworkModule {

    @Singleton
    @Provides
    fun provideApiManager() = ApiManager()
}