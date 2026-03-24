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

    private val _uiEvent = MutableSharedFlow<UiEvent>()
    val uiEvent: SharedFlow<UiEvent> = _uiEvent.asSharedFlow()

    init {
        loadApps()
    }

    private fun loadApps() {
        viewModelScope.launch {
            _uiState.value = getAppUseCase.execute()
        }
    }

    fun onLogoClick() {
        viewModelScope.launch {
            _uiEvent.emit(UiEvent.ShowSnackbar("Нажатие на логотип RuStore"))
        }
    }
}