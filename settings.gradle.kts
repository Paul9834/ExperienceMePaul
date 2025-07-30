// Este archivo settings define los módulos incluidos en el proyecto y configura
// los repositorios para resolver plugins y dependencias.  Los repositorios de
// Google y MavenCentral se utilizan según las recomendaciones de Google para
// proyectos Android modernos.

pluginManagement {
    repositories {
        gradlePluginPortal()
        google()
        mavenCentral()
    }

    // Declaración de plugins con sus versiones.  Es necesario definir
    // explícitamente la versión de cada plugin para que Gradle pueda
    // resolverlos correctamente.  Estos números corresponden a
    // versiones estables a mediados de 2025.
    plugins {
        id("com.android.application") version "8.11.1"
        id("org.jetbrains.kotlin.android") version "2.0.20"
        id("org.jetbrains.kotlin.plugin.compose") version "2.0.20"
        id("com.google.dagger.hilt.android") version "2.56"
        id("com.google.devtools.ksp") version "2.0.20-1.0.24"
    }
}

dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
}

rootProject.name = "Paul9834"
include(":app")