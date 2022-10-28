package com.example.domain.domain.repository

import com.example.domain.domain.models.Bitcoin
import com.example.domain.domain.models.ExchangeRates

interface ListRepository {
    suspend fun getList(currency: ExchangeRates):List<Bitcoin>
}