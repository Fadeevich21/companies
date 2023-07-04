package com.example.companies.di

import com.example.companies.di.utils.AppScope
import com.example.companies.ui.fragment.main.MainFragment
import dagger.Component

@Component(modules = [AppModule::class])
@AppScope
interface AppComponent {

    fun inject(fragment: MainFragment)
}