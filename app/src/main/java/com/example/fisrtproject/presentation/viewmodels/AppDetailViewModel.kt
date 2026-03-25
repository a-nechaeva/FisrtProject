package com.example.fisrtproject.presentation.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.fisrtproject.domain.model.App
import com.example.fisrtproject.domain.usecase.GetAppByIdUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AppDetailViewModel @Inject constructor(
    private val getAppByIdUseCase: GetAppByIdUseCase
) : ViewModel() {

    private val _uiState = MutableLiveData<App?>()
    val uiState: LiveData<App?> = _uiState

    private val _isLoading = MutableLiveData<Boolean>()
    val isLoading: LiveData<Boolean> = _isLoading

    fun loadApp(appId: String) {
        viewModelScope.launch {
            _isLoading.value = true
            getAppByIdUseCase.execute(appId)
                .onSuccess { app ->
                    _uiState.value = app
                }
                .onFailure { error ->
                    _uiState.value = null
                }
            _isLoading.value = false
        }
    }
}