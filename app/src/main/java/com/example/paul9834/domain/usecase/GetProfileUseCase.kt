package com.example.paul9834.domain.usecase

import com.example.paul9834.domain.model.Profile
import com.example.paul9834.domain.repository.ProfileRepository
import javax.inject.Inject

/**
 * Caso de uso que encapsula la lógica para obtener el perfil personal.
 * Recibe un repositorio mediante inyección y expone una función de
 * invocación para ejecutarlo.  Este patrón facilita las pruebas y la
 * reutilización de la lógica.
 */
class GetProfileUseCase @Inject constructor(
    private val repository: ProfileRepository
) {
    suspend operator fun invoke(): Profile {
        return repository.getProfile()
    }
}