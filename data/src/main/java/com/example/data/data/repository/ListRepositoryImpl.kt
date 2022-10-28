package com.example.data.data.repository

import com.example.data.data.model.BitcoinData
import com.example.data.data.storage.BitcoinStorage
import com.example.domain.domain.models.Bitcoin
import com.example.domain.domain.models.ExchangeRates
import com.example.domain.domain.repository.ListRepository


class ListRepositoryImpl(private val storage: BitcoinStorage) : ListRepository {

    override suspend fun getList(currency: ExchangeRates): List<Bitcoin> {
        return mapToDomain(storage.getBitcoinList(currency))

        }
    private fun mapToDomain(bitcoinList: List<BitcoinData>): List<Bitcoin> {
        return bitcoinList.map {
            Bitcoin(it.id, it.name, it.symbol, it.image, it.current_price, it.ath_change_percentage)
        }
    }
}