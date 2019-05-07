package com.playground.utils

import android.app.Application
import com.facebook.stetho.Stetho
import com.playground.dagger.DaggerAppComponent

class App : Application() {

    override fun onCreate() {
        super.onCreate()
        Stetho.initializeWithDefaults(this)
        initDagger {
            DaggerAppComponent.builder().providerAppContext(this).build().inject(this)
        }
    }

    private fun initDagger(block: () -> Unit) {
        block()
    }
}
