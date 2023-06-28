package com.example.companies.di

import com.example.companies.ui.utils.MultiViewModelFactory
import dagger.Component

@Component(modules = [AppModule::class])
interface AppComponent {

    val viewModelFactory: MultiViewModelFactory
}