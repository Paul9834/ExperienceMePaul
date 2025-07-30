package com.example.paul9834.presentation.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.material3.Typography

import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext

/**
 * Tema para la aplicación Paul9834 basado en Material 3.  Selecciona
 * automáticamente colores dinámicos cuando el dispositivo lo permite o
 * utiliza esquemas de colores claros y oscuros predefinidos.
 */
@Composable
fun Paul9834Theme(
    useDarkTheme: Boolean = false,
    content: @Composable () -> Unit
) {
    val context = LocalContext.current
    val colorScheme = when {
        useDarkTheme && android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.S -> {
            dynamicDarkColorScheme(context)
        }
        !useDarkTheme && android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.S -> {
            dynamicLightColorScheme(context)
        }
        useDarkTheme -> {
            darkColorScheme()
        }
        else -> {
            lightColorScheme()
        }
    }
    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography(),
        content = content
    )
}