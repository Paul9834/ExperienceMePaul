package com.example.paul9834.domain.repository

import com.example.paul9834.domain.model.Profile

/**
 * Interfaz de repositorio de dominio que define cómo obtener el perfil.
 * Permite desacoplar la capa de presentación y dominio de la
 * implementación concreta (por ejemplo, red o base de datos).
 */
interface ProfileRepository {
    /**
     * Devuelve el perfil obtenido desde la capa de datos.  Puede lanzar
     * excepciones si la petición de red falla.
     */
    suspend fun getProfile(): Profile
}