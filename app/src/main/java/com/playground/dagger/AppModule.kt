package com.playground.dagger

import android.content.Context
import com.playground.utils.App
import dagger.Binds
import dagger.Module

@Module
abstract class AppModule{

    @Binds abstract fun provideAppContext(appContext: App):Context
}