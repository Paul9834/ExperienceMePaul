package com.example.paul9834

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.paul9834.presentation.profile.ProfileScreen
import com.example.paul9834.presentation.theme.Paul9834Theme
import dagger.hilt.android.AndroidEntryPoint

/**
 * Actividad principal de la aplicación.  Utiliza la arquitectura de una
 * sola actividad para alojar toda la UI construida con Jetpack Compose.
 * Gracias a `@AndroidEntryPoint`, Hilt podrá inyectar el ViewModel
 * necesario en la pantalla【873530393420599†L719-L736】.
 */
@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Paul9834Theme {
                Surface(color = MaterialTheme.colorScheme.background) {
                    val viewModel: com.example.paul9834.presentation.profile.ProfileViewModel = hiltViewModel()
                    ProfileScreen(viewModel = viewModel)
                }
            }
        }
    }
}