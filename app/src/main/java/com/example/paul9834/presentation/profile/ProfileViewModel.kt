package com.example.paul9834.presentation.profile

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.paul9834.domain.usecase.GetProfileUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

/**
 * ViewModel que gestiona la lógica de presentación para la pantalla de
 * perfil.  Solicita los datos mediante el caso de uso correspondiente y
 * expone un estado inmutable que Compose observa para recomponer la UI【873530393420599†L719-L736】.
 */
@HiltViewModel
class ProfileViewModel @Inject constructor(
    private val getProfileUseCase: GetProfileUseCase
) : ViewModel() {
    private val _uiState = MutableStateFlow(ProfileUiState())
    val uiState: StateFlow<ProfileUiState> = _uiState.asStateFlow()

    init {
        // Carga inicial del perfil al iniciar el ViewModel
        loadProfile()
    }

    fun loadProfile() {
        viewModelScope.launch {
            _uiState.value = _uiState.value.copy(isLoading = true, error = null)
            try {
                val profile = getProfileUseCase()
                _uiState.value = ProfileUiState(isLoading = false, profile = profile, error = null)
            } catch (e: Exception) {
                _uiState.value = ProfileUiState(isLoading = false, profile = null, error = e.message ?: "Error desconocido")
            }
        }
    }
}