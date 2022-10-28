package com.example.data.data.storage

import com.example.data.data.model.BitcoinData
import com.example.data.data.model.BitcoinItemData
import com.example.domain.domain.models.ExchangeRates

interface BitcoinStorage {
    suspend fun getBitcoinList(currency: ExchangeRates): List<BitcoinData>
    suspend fun getBitcoinItem(id: String): BitcoinItemData
}