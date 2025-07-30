# Paul9834 – Perfil Personal y CV Mobile

**Paul9834** es una aplicación Android construida en 2025 que presenta un breve sobre mí. Muestra mi nombre, edad y trayectoria profesional como desarrollador móvil, así como los proyectos y puestos relevantes en los que he trabajado. El propósito es servir como portafolio interactivo y escalable.

## Características principales

- **Presentación de perfil**: despliega nombre, edad y rol profesional.
- **Experiencia laboral**: lista los trabajos y proyectos más relevantes, con descripción resumida.
- **Diseño Material 3**: usa Jetpack Compose y Material Design 3 para ofrecer una interfaz moderna y accesible.
- **Flujo de datos unidireccional**: la UI observa un `StateFlow` desde el ViewModel siguiendo las recomendaciones oficiales de Android【873530393420599†L719-L736】.
- **Inyección de dependencias con Hilt**: simplifica la gestión de dependencias y el ciclo de vida de componentes, basada en Dagger【534543669283054†L635-L645】.
- **Arquitectura limpia**: separa responsabilidades en capas de datos, dominio y presentación para facilitar el mantenimiento y la escalabilidad.

## Arquitectura y tecnologías

- **Clean Architecture / MVVM**:
  - **Capa de datos** (`data`): incluye modelos de red (`ProfileResponse.kt`), servicio REST con Retrofit, y un repositorio (`ProfileRepositoryImpl.kt`) que transforma datos remotos en entidades de dominio.
  - **Capa de dominio** (`domain`): define modelos (`Profile.kt`), un repositorio abstracto (`ProfileRepository.kt`) y el caso de uso `GetProfileUseCase` que orquesta la lógica de negocio.
  - **Capa de presentación** (`presentation`): contiene el `ProfileViewModel` y los composables de la UI (`ProfileScreen.kt`), que consumen el estado expuesto por el ViewModel.
- **Jetpack Compose**: toolkit moderno de UI para Android.
- **Material Design 3**: implementado mediante la dependencia `androidx.compose.material3:material3-android` (a partir de 2025 este es el artefacto vigente para Material 3【824689572024129†L104-L200】).
- **Compose BOM**: se usa la versión `2025.07.00` para garantizar compatibilidad entre todas las bibliotecas Compose【485281348548920†L104-L105】.
- **Kotlin 2.0+**: configurado con el plugin `org.jetbrains.kotlin.plugin.compose`, obligatorio desde Kotlin 2.0【282384377757713†L511-L513】.
- **Retrofit y OkHttp**: consumen el endpoint `http://10.0.5.50:8082/admin/v1/paul9834` para obtener el JSON de la hoja de vida.
- **Hilt**: gestiona dependencias y provee singletons a lo largo de la aplicación.
- **Coroutines**: operaciones de red se ejecutan de manera asíncrona.

## Instalación y ejecución

1. **Clonar el repositorio**:
   ```bash
   git clone https://github.com/Paul9834/ExperienceMePaul.git
   cd ExperienceMePaul/app
   ```

2. **Abrir en Android Studio**:
   - Usa Android Studio Hedgehog o posterior.
   - Asegúrate de tener instalado el **SDK 34** y habilitado **Kotlin 2.0.20**.

3. **Construir el proyecto**:
   - Android Studio descargará las dependencias (Compose BOM `2025.07.00`, Hilt `2.56`, Retrofit, etc.).
   - Sincroniza Gradle y ejecuta la aplicación en un emulador o dispositivo físico con **Android 6.0 (API 23)** o superior.

4. **Configuración opcional**:
   - Si el endpoint `10.0.5.50:8082` requiere autenticación o configura un servidor local, ajusta `NetworkModule.kt` en la capa `di` para cambiar la URL base.

## Estructura del repositorio

```
Paul9834/
├── app/
│   ├── build.gradle.kts     # Configuración de módulo y dependencias.
│   └── src/main/
│       ├── java/com/example/paul9834/
│       │   ├── data/        # Modelos de red, servicios Retrofit y repositorio de datos.
│       │   ├── domain/      # Modelos de dominio, casos de uso e interfaces de repositorio.
│       │   ├── di/          # Módulos Hilt que proporcionan Retrofit, OkHttp y repositorios.
│       │   ├── presentation/# ViewModel y composables de la UI.
│       │   ├── MainActivity.kt
│       │   └── MyApplication.kt
│       └── res/values/
│           ├── themes.xml
│           └── ...
└── settings.gradle.kts       # Gestión de plugins y repositorios.
```

## Contribuciones

Cualquier mejora o sugerencia es bienvenida. Puedes abrir un _issue_ o enviar un _pull request_. Este proyecto está pensado para escalarse; nuevas funcionalidades (por ejemplo, proyectos adicionales o secciones de habilidades) deberían agregarse siguiendo la misma estructura de capas, creando casos de uso en `domain`, implementaciones en `data` y vistas en `presentation`.

## Licencia

Este proyecto se distribuye bajo la licencia MIT. Consulta el archivo `LICENSE` para más detalles.
