package com.example.mybitcoinapp.presentation.info

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.domain.domain.usecases.GetItemByIdUseCase
import javax.inject.Inject

class InfoViewModelFactory @Inject constructor(
    private val useCase: GetItemByIdUseCase
    ):ViewModelProvider.Factory {

    override fun <T: ViewModel> create (modelclass: Class<T>): T {
        return InfoViewModel(
            useCase
        ) as T
    }
}