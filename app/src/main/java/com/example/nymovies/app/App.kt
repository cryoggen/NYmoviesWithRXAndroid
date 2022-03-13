package com.example.nymovies.app

import android.app.Application
import android.content.Context
import com.example.nymovies.di.AppComponent
import com.example.nymovies.di.AppModule
import com.example.nymovies.di.DaggerAppComponent

class App : Application() {

    lateinit var appComponent: AppComponent

    override fun onCreate() {
        super.onCreate()
        appComponent = DaggerAppComponent.builder().appModule(AppModule(context = this)).build()
    }
}

val Context.appComponent: AppComponent
    get() = when (this) {
        is App -> appComponent
        else -> applicationContext.appComponent
    }