package com.example.mybitcoinapp

import com.example.domain.domain.models.BitcoinItem

sealed class AppItemState {
    data class Success(val bitcoinItem: BitcoinItem?) : AppItemState()
    data class Error(val error: Throwable) : AppItemState()
    object Loading : AppItemState()
}