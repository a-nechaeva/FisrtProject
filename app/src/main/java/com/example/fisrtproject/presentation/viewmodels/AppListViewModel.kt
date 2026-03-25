package com.example.fisrtproject.presentation.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.fisrtproject.domain.model.App
import com.example.fisrtproject.domain.usecase.GetAppUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

sealed class UiEvent {
    data class ShowSnackbar(val message: String) : UiEvent()
}

@HiltViewModel
class AppListViewModel @Inject constructor(
    private val getAppUseCase: GetAppUseCase
) : ViewModel() {

    private val _uiState = MutableStateFlow<List<App>>(emptyList())
    val uiState: StateFlow<List<App>> = _uiState.asStateFlow()

    private val _isLoading = MutableStateFlow(false)
    val isLoading: StateFlow<Boolean> = _isLoading.asStateFlow()

    private val _uiEvent = MutableSharedFlow<UiEvent>()
    val uiEvent: SharedFlow<UiEvent> = _uiEvent.asSharedFlow()

    private val _isError = MutableStateFlow(false)
    val isError: StateFlow<Boolean> = _isError.asStateFlow()

    init {
        loadApps()
    }

    private fun loadApps() {
        viewModelScope.launch {
            _isLoading.value = true
            _isError.value = false
            getAppUseCase.execute()
                .onSuccess { apps ->
                    _uiState.value = apps
                    _isError.value = false
                }
                .onFailure { error ->
                    _isError.value = true
                    _uiEvent.emit(UiEvent.ShowSnackbar("Ошибка загрузки: ${error.message}"))
                }
            _isLoading.value = false
        }
    }

    fun onLogoClick() {
        viewModelScope.launch {
            _uiEvent.emit(UiEvent.ShowSnackbar("Нажатие на логотип RuStore"))
        }
    }

    fun refresh() {
        loadApps()
    }
}