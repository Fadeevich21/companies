package com.example.companies.di

import android.content.Context
import com.example.companies.di.utils.AppScope
import com.example.companies.ui.fragment.allCompanies.AllCompaniesFragment
import com.example.companies.ui.fragment.companiesAnalysisInfo.CompaniesAnalysisInfoFragment
import com.example.companies.ui.fragment.main.MainFragment
import com.example.companies.ui.fragment.reports.ReportsFragment
import com.example.data.di.DataModule
import dagger.BindsInstance
import dagger.Component

@Component(modules = [AppModule::class, DataModule::class])
@AppScope
interface AppComponent {

    @Component.Builder
    interface Builder {

        @BindsInstance
        fun context(context: Context): Builder

        fun build(): AppComponent
    }

    fun inject(fragment: MainFragment)
    fun inject(fragment: AllCompaniesFragment)
    fun inject(fragment: ReportsFragment)
    fun inject(fragment: CompaniesAnalysisInfoFragment)
}