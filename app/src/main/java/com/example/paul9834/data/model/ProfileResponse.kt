package com.example.paul9834.data.model

import com.google.gson.annotations.SerializedName

/**
 * Modelo para mapear la respuesta JSON del endpoint de la hoja de vida.
 * Los nombres de las propiedades están anotados para coincidir con
 * posibles claves del JSON.  Posteriormente se convertirán a los
 * modelos de dominio correspondientes.
 */
data class ProfileResponse(
    @SerializedName("name") val name: String?,
    @SerializedName("age") val age: Int?,
    @SerializedName("role") val role: String?,
    @SerializedName("experience") val experience: List<String>?,
    @SerializedName("jobs") val jobs: List<JobResponse>?
)

data class JobResponse(
    @SerializedName("company") val company: String?,
    @SerializedName("position") val position: String?,
    @SerializedName("duration") val duration: String?
)