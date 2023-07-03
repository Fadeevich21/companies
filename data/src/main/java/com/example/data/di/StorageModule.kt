package com.example.data.di

import com.example.data.storage.AssetCompanyStorage
import com.example.data.storage.utils.CompanyStorage
import dagger.Binds
import dagger.Module

@Module(includes = [StorageBindsModule::class])
class StorageModule

@Module
private interface StorageBindsModule {

    @Binds
    fun bindCompanyStorage(companyStorage: AssetCompanyStorage): CompanyStorage
}