package com.example.paul9834

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

/**
 * Clase de aplicación personalizada anotada con `@HiltAndroidApp`.  Esto
 * permite a Hilt generar automáticamente un contenedor de dependencias a
 * nivel de aplicación y preparar la inyección en todas las clases
 * Android【534543669283054†L731-L748】.
 */
@HiltAndroidApp
class MyApplication : Application()