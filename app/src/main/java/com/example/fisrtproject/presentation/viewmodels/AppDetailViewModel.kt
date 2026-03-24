package com.example.fisrtproject.presentation.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.fisrtproject.domain.model.App
import com.example.fisrtproject.domain.usecase.GetAppByIdUseCase

class AppDetailViewModel(
        private val getAppByIdUseCase: GetAppByIdUseCase
) : ViewModel() {

    private val _uiState = MutableLiveData<App?>()
    val uiState: LiveData<App?> = _uiState

    fun loadApp(appId: String) {
        _uiState.value = getAppByIdUseCase.execute(appId)
    }
}
