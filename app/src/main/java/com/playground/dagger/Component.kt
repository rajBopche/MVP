package com.playground.dagger

import com.playground.login.LoginPresenter
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [NetworkModule::class])
interface Component {
    fun inject(mPresenter: LoginPresenter)
}