package com.example.mvvmdemo.core

import android.app.Application
import android.util.Log

class AppContext: Application() {

    override fun onCreate() {
        Log.d("app","applcation start")
        super.onCreate()
    }
}