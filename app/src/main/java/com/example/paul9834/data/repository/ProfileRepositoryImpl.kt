package com.example.paul9834.data.repository

import com.example.paul9834.data.model.JobResponse
import com.example.paul9834.data.model.ProfileResponse
import com.example.paul9834.data.remote.ProfileService
import com.example.paul9834.domain.model.Job
import com.example.paul9834.domain.model.Profile
import com.example.paul9834.domain.repository.ProfileRepository
import javax.inject.Inject

/**
 * Implementación concreta de [ProfileRepository] que obtiene los datos de
 * la red y los transforma a modelos de dominio.  Utiliza el servicio
 * Retrofit para comunicarse con el servidor y maneja valores nulos
 * proporcionando valores predeterminados.
 */
class ProfileRepositoryImpl @Inject constructor(
    private val service: ProfileService
) : ProfileRepository {
    override suspend fun getProfile(): Profile {
        val response: ProfileResponse = service.getProfile()
        return Profile(
            name = response.name ?: "",
            age = response.age ?: 0,
            role = response.role ?: "",
            experience = response.experience ?: emptyList(),
            jobs = response.jobs?.map { it.toDomain() } ?: emptyList()
        )
    }

    private fun JobResponse.toDomain(): Job {
        return Job(
            company = company ?: "",
            position = position ?: "",
            duration = duration ?: ""
        )
    }
}