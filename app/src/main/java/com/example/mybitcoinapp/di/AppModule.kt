package com.example.mybitcoinapp.di

import com.example.domain.domain.usecases.GetItemByIdUseCase
import com.example.domain.domain.usecases.GetListByPageUseCase
import com.example.mybitcoinapp.presentation.info.InfoViewModelFactory
import com.example.mybitcoinapp.presentation.list.ListViewModelFactory
import dagger.Module
import dagger.Provides

@Module
class AppModule {

    @Provides
    fun provideInfoViewModelFactory(useCase: GetItemByIdUseCase): InfoViewModelFactory {
        return InfoViewModelFactory (useCase)
    }

    @Provides
    fun provideListViewModelFactory(useCase: GetListByPageUseCase): ListViewModelFactory {
        return ListViewModelFactory (useCase)
    }
}