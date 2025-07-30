package com.example.paul9834.domain.model

/**
 * Modelo de dominio que resume la información del perfil personal.
 * Incluye el nombre, la edad, el rol profesional, una lista de
 * experiencias y un historial de trabajos.
 */
data class Profile(
    val name: String,
    val age: Int,
    val role: String,
    val experience: List<String>,
    val jobs: List<Job>
)

/**
 * Modelo de dominio para un trabajo específico.  Registra la empresa,
 * el puesto y la duración del empleo.
 */
data class Job(
    val company: String,
    val position: String,
    val duration: String
)