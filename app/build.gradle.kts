// Script de construcción para el módulo de aplicación.  Aquí se configuran
// las opciones de compilación, Kotlin, Compose y se declaran todas las
// dependencias de biblioteca.  Se utiliza la arquitectura limpia con
// inyección de dependencias y Jetpack Compose para la interfaz.

plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    id("com.google.dagger.hilt.android")
    id("com.google.devtools.ksp")
    // El plugin del compilador Compose es necesario con Kotlin 2.0 o superior.  Este plugin
    // separa la versión del compilador Compose de las bibliotecas de UI y se configura
    // mediante el bloque pluginManagement en settings.gradle.kts【282384377757713†L511-L513】.
    id("org.jetbrains.kotlin.plugin.compose")
}

android {
    namespace = "com.example.paul9834"
    compileSdk = 35

    defaultConfig {
        applicationId = "com.example.paul9834"
        minSdk = 23
        targetSdk = 35
        versionCode = 1
        versionName = "1.0"

        multiDexEnabled = true
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
        debug {
            isDebuggable = true
        }
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
    kotlinOptions {
        jvmTarget = "17"
    }

    buildFeatures {
        compose = true
    }
    packaging {
        resources {
            excludes += setOf(
                "/META-INF/{AL2.0,LGPL2.1}",
                "META-INF/DEPENDENCIES"
            )
        }
    }
}

dependencies {
    // Core Android
    implementation("androidx.core:core-ktx:1.12.0")
    implementation("androidx.lifecycle:lifecycle-runtime-ktx:2.6.2")
    implementation("androidx.activity:activity-compose:1.8.2")

    // Compose BOM y Material Design 3.  A partir de 2025 el paquete Material 3 se publica
    // como `material3-android`; el antiguo identificador `material3` fue retirado.  Se
    // actualiza la versión del BOM a 2025.07.00 para usar las bibliotecas más recientes
    // disponibles en julio de 2025【824689572024129†L104-L200】【485281348548920†L104-L105】.
    implementation(platform("androidx.compose:compose-bom:2025.07.00"))
    implementation("androidx.compose.ui:ui")
    implementation("androidx.compose.ui:ui-tooling-preview")
    implementation("androidx.compose.material3:material3-android")
    implementation("com.google.android.material:material:1.12.0")


    // ViewModel y navegación con Hilt en Compose【873530393420599†L719-L736】
    implementation("androidx.lifecycle:lifecycle-viewmodel-compose:2.6.2")
    implementation("androidx.hilt:hilt-navigation-compose:1.2.0")

    // Corutinas
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-android:1.7.3")

    // Retrofit y OkHttp para red
    implementation("com.squareup.retrofit2:retrofit:2.9.0")
    implementation("com.squareup.retrofit2:converter-gson:2.9.0")
    implementation("com.squareup.okhttp3:logging-interceptor:5.0.0-alpha.6")

    // Hilt
    implementation("com.google.dagger:hilt-android:2.56")
    ksp("com.google.dagger:hilt-android-compiler:2.56")
    implementation("androidx.hilt:hilt-navigation-compose:1.2.0")

    // Pruebas
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")
    androidTestImplementation(platform("androidx.compose:compose-bom:2025.07.00"))
    androidTestImplementation("androidx.compose.ui:ui-test-junit4")
    debugImplementation("androidx.compose.ui:ui-tooling")
    debugImplementation("androidx.compose.ui:ui-test-manifest")
}