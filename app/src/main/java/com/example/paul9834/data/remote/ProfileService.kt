package com.example.paul9834.data.remote

import com.example.paul9834.data.model.ProfileResponse
import retrofit2.http.GET

/**
 * Interfaz de Retrofit que declara el endpoint para obtener el perfil.  La
 * anotación `@GET` define una llamada HTTP GET a la ruta indicada.  El
 * convertidor Gson configurado en Retrofit se encarga de convertir la
 * respuesta JSON en [ProfileResponse].
 */
interface ProfileService {
    @GET("admin/v1/paul9834")
    suspend fun getProfile(): ProfileResponse
}