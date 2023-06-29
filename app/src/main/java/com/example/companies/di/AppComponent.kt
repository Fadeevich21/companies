package com.example.companies.di

import com.example.companies.ui.fragment.main.MainFragment
import com.example.companies.ui.utils.MultiViewModelFactory
import dagger.Component

@Component(modules = [AppModule::class])
interface AppComponent {
    fun inject(fragment: MainFragment)
}