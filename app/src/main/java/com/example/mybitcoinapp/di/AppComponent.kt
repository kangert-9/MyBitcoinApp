package com.example.mybitcoinapp.di

import com.example.mybitcoinapp.presentation.MainActivity
import com.example.mybitcoinapp.presentation.info.InfoFragment
import com.example.mybitcoinapp.presentation.list.ItemListFragment
import dagger.Component
import javax.inject.Singleton

@Component(
    modules = [
        AppModule::class,
        ApiModule::class,
        DataModule::class,
        DomainModule::class
    ]
)

@Singleton
interface AppComponent {
    fun inject(mainActivity: MainActivity)
    fun inject(itemListFragment: ItemListFragment)
    fun inject(infoFragment: InfoFragment)
}