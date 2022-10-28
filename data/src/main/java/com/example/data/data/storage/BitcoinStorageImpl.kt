package com.example.data.data.storage

import com.example.data.data.model.BitcoinData
import com.example.data.data.model.BitcoinItemData
import com.example.data.data.retrofit.BitcoinApi
import com.example.domain.domain.models.ExchangeRates

class BitcoinStorageImpl (private val bitcoinApi: BitcoinApi): BitcoinStorage {

    override suspend fun getBitcoinList(currency: ExchangeRates): List<BitcoinData> {
        return bitcoinApi.fetchItems(currency.currency, 20)
    }

    override suspend fun getBitcoinItem(id: String): BitcoinItemData {
        return bitcoinApi.fetchItemById(id)
    }
}