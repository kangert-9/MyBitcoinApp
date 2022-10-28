package com.example.mybitcoinapp

import com.example.domain.domain.models.Bitcoin


sealed class AppListState {
    data class Success(val bitcoinList: List<Bitcoin>) : AppListState()
    data class Error(val error: Throwable) : AppListState()
    object Loading : AppListState()
}
