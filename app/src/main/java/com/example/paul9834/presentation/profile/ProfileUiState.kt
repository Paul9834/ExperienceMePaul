package com.example.paul9834.presentation.profile

import com.example.paul9834.domain.model.Profile

/**
 * Estado de la interfaz para la pantalla de perfil.  Incluye un flag
 * de carga, el perfil obtenido (si existe) y un mensaje de error para
 * mostrar cuando hay fallos.
 */
data class ProfileUiState(
    val isLoading: Boolean = false,
    val profile: Profile? = null,
    val error: String? = null
)