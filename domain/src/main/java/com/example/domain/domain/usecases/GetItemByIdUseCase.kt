package com.example.domain.domain.usecases

import com.example.domain.domain.models.BitcoinItem
import com.example.domain.domain.repository.ItemRepository

class GetItemByIdUseCase (
    private val repository: ItemRepository
    ) {

    suspend fun execute(id: String): BitcoinItem {
        return repository.getItem(id)
    }
}