package com.example.mybitcoinapp.presentation.list

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.domain.domain.usecases.GetListByPageUseCase
import javax.inject.Inject

class ListViewModelFactory @Inject constructor(
    private val useCase: GetListByPageUseCase
    ): ViewModelProvider.Factory {

    override fun <T: ViewModel> create (modelclass: Class<T>): T {
        return ListViewModel(
            useCase
        ) as T
    }
}