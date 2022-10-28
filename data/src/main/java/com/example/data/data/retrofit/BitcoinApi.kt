package com.example.data.data.retrofit

import com.example.data.data.model.BitcoinData
import com.example.data.data.model.BitcoinItemData
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface BitcoinApi {
    @GET("coins/markets")
    suspend fun fetchItems(@Query("vs_currency") vs_currency: String,
                           @Query("per_page") per_page: Int
    ): List<BitcoinData>

    @GET("coins/{id}")
    suspend fun fetchItemById (@Path("id") id: String
    ): BitcoinItemData
}