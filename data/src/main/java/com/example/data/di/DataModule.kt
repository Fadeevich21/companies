package com.example.data.di

import dagger.Module

@Module(includes = [RepositoryModule::class, StorageModule::class])
class DataModule