package com.example.data.di

import com.example.data.repository.CompanyRepositoryImpl
import com.example.domain.repository.CompanyRepository
import dagger.Binds
import dagger.Module

@Module(includes = [RepositoryBindsModule::class])
class RepositoryModule

@Module
private interface RepositoryBindsModule {

    @Binds
    fun bindCompanyRepository(repository: CompanyRepositoryImpl): CompanyRepository
}