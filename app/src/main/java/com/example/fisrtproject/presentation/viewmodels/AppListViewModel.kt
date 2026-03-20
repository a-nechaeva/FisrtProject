package com.example.fisrtproject.presentation.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.fisrtproject.data.local.AppData
import com.example.fisrtproject.data.model.AppDetailsDto
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

sealed class UiEvent {
    data class ShowSnackbar(val message: String) : UiEvent()
}

class AppListViewModel : ViewModel() {
    private val _uiState = MutableStateFlow<List<AppDetailsDto>>(emptyList())
    val uiState: StateFlow<List<AppDetailsDto>> = _uiState.asStateFlow()

    private val _uiEvent = MutableSharedFlow<UiEvent>()
    val uiEvent: SharedFlow<UiEvent> = _uiEvent.asSharedFlow()

    init {
        loadApps()
    }

    private fun loadApps() {
        _uiState.value = AppData.appList
    }

    fun onLogoClick() {
        viewModelScope.launch {
            _uiEvent.emit(UiEvent.ShowSnackbar("Нажатие на логотип RuStore"))
        }
    }
}