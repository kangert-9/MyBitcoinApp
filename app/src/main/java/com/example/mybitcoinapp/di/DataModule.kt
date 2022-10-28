package com.example.mybitcoinapp.di

import com.example.data.data.repository.ItemRepositoryImpl
import com.example.data.data.repository.ListRepositoryImpl
import com.example.data.data.retrofit.BitcoinApi
import com.example.data.data.storage.BitcoinStorage
import com.example.data.data.storage.BitcoinStorageImpl
import com.example.domain.domain.repository.ItemRepository
import com.example.domain.domain.repository.ListRepository
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class DataModule {

    @Provides
    fun provideBitcoinStorage(bitcoinApi: BitcoinApi): BitcoinStorage{
        return BitcoinStorageImpl (bitcoinApi)
    }

    @Singleton
    @Provides
    fun provideItemRepository(storage: BitcoinStorage): ItemRepository {
        return ItemRepositoryImpl(storage)
    }

    @Singleton
    @Provides
    fun provideListRepository(storage: BitcoinStorage): ListRepository {
        return ListRepositoryImpl(storage)
    }
}