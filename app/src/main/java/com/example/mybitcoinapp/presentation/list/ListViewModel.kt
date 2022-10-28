package com.example.mybitcoinapp.presentation.list

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.example.domain.domain.models.ExchangeRates
import com.example.domain.domain.usecases.GetListByPageUseCase
import com.example.mybitcoinapp.AppListState
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class ListViewModel(private val useCase: GetListByPageUseCase): ViewModel() {

    fun getData (currency: ExchangeRates): LiveData<AppListState> = liveData {
        emit(AppListState.Loading)
        withContext(Dispatchers.IO) {
            try {
                emit(
                    AppListState.Success(useCase.execute(currency)))
            } catch (e: Exception) {
                emit(AppListState.Error(e))
            }
        }
    }

}