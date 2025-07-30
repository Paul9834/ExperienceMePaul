package com.example.paul9834.presentation.profile

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

/**
 * Pantalla Compose que muestra el perfil personal.  Observa el estado
 * proveniente del ViewModel y actualiza la UI en consecuencia: carga,
 * error o contenido.  Utiliza un Scaffold para estructurar la barra
 * superior y el área de contenido desplazable.
 */

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProfileScreen(viewModel: ProfileViewModel) {
    val state by viewModel.uiState.collectAsState()
    Scaffold(
        topBar = {
            TopAppBar(title = { Text(text = "Mi perfil") })
        },
        content = { innerPadding ->
            Column(modifier = Modifier.padding(innerPadding)) {
                when {
                    state.isLoading -> {
                        CircularProgressIndicator(modifier = Modifier.padding(16.dp))
                    }
                    state.error != null -> {
                        Text(
                            text = state.error ?: "",
                            color = MaterialTheme.colorScheme.error,
                            modifier = Modifier.padding(16.dp)
                        )
                        Button(onClick = { viewModel.loadProfile() }, modifier = Modifier.padding(16.dp)) {
                            Text(text = "Reintentar")
                        }
                    }
                    state.profile != null -> {
                        val profile = state.profile
                        if (profile != null) {
                            LazyColumn(modifier = Modifier.padding(16.dp)) {
                                item {
                                    Text(
                                        text = profile.name,
                                        fontSize = 24.sp,
                                        fontWeight = FontWeight.Bold,
                                        modifier = Modifier.padding(bottom = 4.dp)
                                    )
                                    Text(
                                        text = "Edad: ${profile.age}",
                                        fontSize = 16.sp,
                                        modifier = Modifier.padding(bottom = 8.dp)
                                    )
                                    Text(
                                        text = profile.role,
                                        fontSize = 18.sp,
                                        fontWeight = FontWeight.SemiBold,
                                        modifier = Modifier.padding(bottom = 12.dp)
                                    )
                                    Text(
                                        text = "Experiencia",
                                        fontSize = 20.sp,
                                        fontWeight = FontWeight.Bold,
                                        modifier = Modifier.padding(bottom = 4.dp)
                                    )
                                }
                                items(profile.experience) { exp ->
                                    Text(text = "\u2022 $exp", modifier = Modifier.padding(start = 8.dp, bottom = 2.dp))
                                }
                                item {
                                    Text(
                                        text = "Trabajos",
                                        fontSize = 20.sp,
                                        fontWeight = FontWeight.Bold,
                                        modifier = Modifier.padding(top = 12.dp, bottom = 4.dp)
                                    )
                                }
                                items(profile.jobs) { job ->
                                    Text(
                                        text = job.company,
                                        fontSize = 16.sp,
                                        fontWeight = FontWeight.SemiBold,
                                        modifier = Modifier.padding(top = 4.dp)
                                    )
                                    Text(text = job.position, modifier = Modifier.padding(start = 8.dp))
                                    Text(text = job.duration, modifier = Modifier.padding(start = 8.dp, bottom = 8.dp))
                                }
                                item {
                                    Button(onClick = { viewModel.loadProfile() }, modifier = Modifier.padding(top = 16.dp)) {
                                        Text(text = "Actualizar datos")
                                    }
                                }
                            }
                        }
                    }
                    else -> {
                        // No se muestra contenido si el estado está vacío
                    }
                }
            }
        }
    )
}