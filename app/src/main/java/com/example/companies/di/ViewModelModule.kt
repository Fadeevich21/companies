package com.example.companies.di

import androidx.lifecycle.ViewModel
import com.example.companies.ui.fragment.allCompanies.AllCompaniesViewModel
import com.example.companies.ui.fragment.main.MainViewModel
import com.example.companies.ui.fragment.companiesAnalysisInfo.CompaniesAnalysisInfoViewModel
import com.example.companies.ui.fragment.reports.ReportsViewModel
import com.example.companies.ui.utils.ViewModelKey
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module(includes = [ViewModelBindsModule::class])
class ViewModelModule

@Module
private interface ViewModelBindsModule {

    @Binds
    @[IntoMap ViewModelKey(MainViewModel::class)]
    fun provideMainViewModel(mainViewModel: MainViewModel): ViewModel

    @Binds
    @[IntoMap ViewModelKey(AllCompaniesViewModel::class)]
    fun provideAllCompaniesViewModel(viewModel: AllCompaniesViewModel): ViewModel

    @Binds
    @[IntoMap ViewModelKey(ReportsViewModel::class)]
    fun provideReportsViewModel(viewModel: ReportsViewModel): ViewModel

    @Binds
    @[IntoMap ViewModelKey(CompaniesAnalysisInfoViewModel::class)]
    fun provideCompanyAnalysisInfoViewModel(viewModel: CompaniesAnalysisInfoViewModel): ViewModel
}