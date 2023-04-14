package com.example.testpragma.view.main

import com.example.testpragma.repository.main.IMainActivityRepository
import com.example.testpragma.repository.main.MainActivityRepository
import com.example.testpragma.retrofit.ApiInterface
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
class MainModule {

    @Provides
    fun provideAboutRepository(apiInterface: ApiInterface): IMainActivityRepository {
        return MainActivityRepository(apiInterface)
    }
}