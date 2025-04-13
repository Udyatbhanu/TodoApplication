package com.bhanu.baliyar.todoapplication.core

import android.app.Application

class TodoApplication : Application() {
    lateinit var container: AppContainer

    override fun onCreate() {
        super.onCreate()
        container = AppContainer()
    }
}