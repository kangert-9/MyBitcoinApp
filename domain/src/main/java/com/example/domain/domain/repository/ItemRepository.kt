package com.example.domain.domain.repository

import com.example.domain.domain.models.BitcoinItem

interface ItemRepository {
    suspend fun getItem(id: String): BitcoinItem
}