package com.playground.dagger

import com.playground.login.LoginPresenter
import com.playground.utils.App
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [NetworkModule::class, AppModule::class])
interface AppComponent {
    fun inject(application: App)
    fun inject(loginPresenter: LoginPresenter)

    @Component.Builder
    interface Builder {
        fun build(): AppComponent
        @BindsInstance
        fun providerAppContext(appContext: App): Builder
    }
}