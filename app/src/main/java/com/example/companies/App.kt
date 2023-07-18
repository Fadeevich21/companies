package com.example.companies

import android.app.Application
import com.example.companies.di.AppComponent
import com.example.companies.di.DaggerAppComponent

class App : Application() {

    val appComponent: AppComponent = DaggerAppComponent.builder()
        .context(this)
        .build()
}