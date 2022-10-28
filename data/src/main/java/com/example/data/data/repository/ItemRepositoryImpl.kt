package com.example.data.data.repository

import com.example.data.data.model.BitcoinItemData
import com.example.data.data.storage.BitcoinStorage
import com.example.domain.domain.models.BitcoinItem
import com.example.domain.domain.models.Description
import com.example.domain.domain.models.Image
import com.example.domain.domain.repository.ItemRepository

class ItemRepositoryImpl (private val storage: BitcoinStorage): ItemRepository {

    override suspend fun getItem(id: String): BitcoinItem {
        return mapToDomain(storage.getBitcoinItem(id))
    }

    private suspend fun mapToDomain(bitcoinItem: BitcoinItemData): BitcoinItem {
        return BitcoinItem(bitcoinItem.id,
            bitcoinItem.name,
            Image(bitcoinItem.image?.large),
            Description(bitcoinItem.description?.en),
            bitcoinItem.categories
        )
    }
}