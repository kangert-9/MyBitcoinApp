package com.example.mybitcoinapp.presentation.info

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.example.domain.domain.usecases.GetItemByIdUseCase
import com.example.mybitcoinapp.AppItemState
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class InfoViewModel (private val useCase: GetItemByIdUseCase): ViewModel() {

    fun getData (id: String): LiveData<AppItemState> = liveData {
        emit(AppItemState.Loading)
        withContext(Dispatchers.IO) {
            try {
                emit(AppItemState.Success(useCase.execute(id)))
            } catch (e: Exception) {
                emit(AppItemState.Error(e))
            }
        }
    }
}