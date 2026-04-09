package com.example.fisrtproject.presentation.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.fisrtproject.domain.model.AppDetails
import com.example.fisrtproject.domain.usecase.GetAppDetailsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AppDetailViewModel @Inject constructor(
    private val getAppDetailsUseCase: GetAppDetailsUseCase
) : ViewModel() {

    private val _uiState = MutableLiveData<AppDetails?>()
    val uiState: LiveData<AppDetails?> = _uiState

    private val _isLoading = MutableLiveData<Boolean>()
    val isLoading: LiveData<Boolean> = _isLoading

    private val _error = MutableLiveData<String?>()
    val error: LiveData<String?> = _error

    private suspend fun loadAppDetails(appId: String) {
        _isLoading.value = true
        _error.value = null

        getAppDetailsUseCase.execute(appId)
            .onSuccess { appDetails ->
                _uiState.value = appDetails
            }
            .onFailure { throwable ->
                _error.value = throwable.message ?: "Произошла ошибка"
                _uiState.value = null
            }

        _isLoading.value = false
    }

    fun fetchAppDetails(appId: String) {
        viewModelScope.launch {
            loadAppDetails(appId)
        }
    }

}