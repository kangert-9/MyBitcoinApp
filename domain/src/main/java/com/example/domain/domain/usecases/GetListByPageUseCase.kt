package com.example.domain.domain.usecases

import com.example.domain.domain.models.Bitcoin
import com.example.domain.domain.models.ExchangeRates
import com.example.domain.domain.repository.ListRepository

class GetListByPageUseCase (
    private val repository: ListRepository
    ){

    suspend fun execute(currency: ExchangeRates): List<Bitcoin> {
         return repository.getList(currency)
    }
}