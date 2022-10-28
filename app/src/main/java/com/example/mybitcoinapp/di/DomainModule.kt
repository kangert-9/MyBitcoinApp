package com.example.mybitcoinapp.di

import com.example.domain.domain.repository.ItemRepository
import com.example.domain.domain.repository.ListRepository
import com.example.domain.domain.usecases.GetItemByIdUseCase
import com.example.domain.domain.usecases.GetListByPageUseCase
import dagger.Module
import dagger.Provides

@Module
class DomainModule {

    @Provides
    fun provideGetItemByIdUseCase (repository: ItemRepository): GetItemByIdUseCase {
        return GetItemByIdUseCase(repository)
    }

    @Provides
    fun provideGetListByPageUseCase (repository: ListRepository): GetListByPageUseCase {
        return GetListByPageUseCase(repository)
    }
}