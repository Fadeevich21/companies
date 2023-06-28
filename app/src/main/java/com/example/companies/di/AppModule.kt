package com.example.companies.di

import androidx.lifecycle.ViewModel
import com.example.companies.ui.fragment.main.MainViewModel
import com.example.companies.ui.utils.ViewModelKey
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module(includes = [AppBindsModule::class])
class AppModule

@Module
interface AppBindsModule {

    @Binds
    @[IntoMap ViewModelKey(MainViewModel::class)]
    fun provideMainViewModel(mainViewModel: MainViewModel): ViewModel
}