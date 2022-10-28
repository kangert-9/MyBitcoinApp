package com.example.mybitcoinapp

import android.app.Application
import com.example.mybitcoinapp.di.*

class App : Application() {

    lateinit var appComponent: AppComponent

    override fun onCreate() {
        super.onCreate()
        appComponent = DaggerAppComponent.create()
    }
}
