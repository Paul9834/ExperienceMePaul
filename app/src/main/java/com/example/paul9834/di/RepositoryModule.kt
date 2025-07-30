package com.example.paul9834.di

import com.example.paul9834.data.repository.ProfileRepositoryImpl
import com.example.paul9834.domain.repository.ProfileRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

/**
 * Módulo de Hilt para vincular las interfaces con sus implementaciones.
 * Asocia [ProfileRepository] a su implementación concreta
 * [ProfileRepositoryImpl] en el grafo de dependencias.
 */
@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {
    @Binds
    @Singleton
    abstract fun bindProfileRepository(
        impl: ProfileRepositoryImpl
    ): ProfileRepository
}