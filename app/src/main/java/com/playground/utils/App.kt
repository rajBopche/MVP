package com.playground.utils

import android.app.Application
import android.content.Context
import com.facebook.stetho.Stetho

class App: Application()
{

    override fun onCreate()
    {
        super.onCreate()
        Stetho.initializeWithDefaults(this)
    }

    fun getAppContext(): Context
    {
        return applicationContext
    }
}
