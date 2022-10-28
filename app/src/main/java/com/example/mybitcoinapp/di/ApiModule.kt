package com.example.mybitcoinapp.di

import com.example.data.data.retrofit.BitcoinApi
import com.example.mybitcoinapp.URL
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Named
import javax.inject.Singleton

@Module
class ApiModule {
    @Named("baseUrl")
    @Provides
    fun baseUrl(): String = URL
    @Provides
    fun api(@Named("baseUrl") baseUrl: String, gson: Gson): BitcoinApi =
        Retrofit.Builder()
            .baseUrl(baseUrl)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .client(client())
            .build()
            .create(BitcoinApi::class.java)
    @Singleton
    @Provides
    fun gson() = GsonBuilder().create()

    @Singleton
    @Provides
    fun client() = OkHttpClient.Builder()
        .addNetworkInterceptor(
            HttpLoggingInterceptor().apply {
                level = HttpLoggingInterceptor.Level.BODY
            }
        )
        .build()
}