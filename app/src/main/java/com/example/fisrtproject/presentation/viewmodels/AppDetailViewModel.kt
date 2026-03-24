package com.example.fisrtproject.presentation.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.fisrtproject.domain.model.App
import com.example.fisrtproject.domain.usecase.GetAppByIdUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class AppDetailViewModel @Inject constructor(
        private val getAppByIdUseCase: GetAppByIdUseCase
) : ViewModel() {

    private val _uiState = MutableLiveData<App?>()
    val uiState: LiveData<App?> = _uiState

    fun loadApp(appId: String) {
        _uiState.value = getAppByIdUseCase.execute(appId)
    }
}
