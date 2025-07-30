# Paul9834 – Perfil Personal y CV Mobile

**Paul9834** es una aplicación Android desarrollada en 2025 que presenta un breve perfil personal. Muestra mi nombre, edad y trayectoria profesional como desarrollador móvil, así como los proyectos y cargos más relevantes en los que he trabajado. El objetivo es servir como portafolio interactivo y escalable.

## Características principales

- **Presentación de perfil**: muestra nombre, edad y rol profesional.
- **Experiencia laboral**: lista los trabajos y proyectos más relevantes, con descripción resumida.
- **Diseño Material 3**: utiliza Jetpack Compose y Material Design 3 para una interfaz moderna y accesible.
- **Flujo de datos unidireccional**: la UI observa un `StateFlow` desde el ViewModel, siguiendo las recomendaciones oficiales de Android.
- **Inyección de dependencias con Hilt**: facilita la gestión de dependencias y el ciclo de vida de los componentes.
- **Arquitectura limpia**: separa responsabilidades en capas de datos, dominio y presentación para mejor mantenimiento y escalabilidad.

## Arquitectura y tecnologías

- **Clean Architecture / MVVM**:
    - **Capa de datos (`data`)**: modelos de red, servicio REST con Retrofit y repositorio que transforma datos remotos en entidades de dominio.
    - **Capa de dominio (`domain`)**: modelos de dominio, repositorio abstracto y caso de uso que orquesta la lógica de negocio.
    - **Capa de presentación (`presentation`)**: ViewModel y composables de la UI que consumen el estado expuesto por el ViewModel.
- **Jetpack Compose**: toolkit moderno de UI para Android.
- **Material Design 3**: implementado mediante `androidx.compose.material3:material3-android`.
- **Compose BOM**: versión `2025.07.00` para garantizar compatibilidad entre bibliotecas Compose.
- **Kotlin 2.0+**: configurado con el plugin oficial `org.jetbrains.kotlin.plugin.compose`.
- **Retrofit y OkHttp**: consumen el endpoint `http://10.0.5.50:8082/admin/v1/paul9834` para obtener el JSON de la hoja de vida.
- **Hilt**: gestiona dependencias y provee singletons en la aplicación.
- **Coroutines**: operaciones de red asíncronas.

## Instalación y ejecución

1. **Clonar el repositorio:**
    ```bash
    git clone https://github.com/Paul9834/ExperienceMePaul.git
    cd ExperienceMePaul/app
    ```

2. **Abrir en Android Studio:**
    - Usa Android Studio Hedgehog o superior.
    - Ten instalado el **SDK 34** y habilitado **Kotlin 2.0.20**.

3. **Construir el proyecto:**
    - Android Studio descargará las dependencias necesarias.
    - Sincroniza Gradle y ejecuta la aplicación en un emulador o dispositivo físico con **Android 6.0 (API 23)** o superior.

4. **Configuración opcional:**
    - Si el endpoint requiere autenticación o servidor local, ajusta `NetworkModule.kt` en la capa `di` para cambiar la URL base.

## Estructura del repositorio
```
Paul9834
├── app
│   ├── build.gradle.kts
│   └── src
│       └── main
│           ├── java
│           │   └── com
│           │       └── example
│           │           └── paul9834
│           │               ├── data               ← Modelos de red, servicios, repositorio concreto
│           │               ├── domain             ← Modelos de dominio, interfaces, casos de uso
│           │               ├── di                 ← Módulos Hilt para inyección de dependencias
│           │               ├── presentation       ← UI (composables), ViewModel y lógica de presentación
│           │               ├── MainActivity.kt    ← Entry point de la app
│           │               └── MyApplication.kt   ← Clase de aplicación, arranque de Hilt
│           └── res
│               └── values
│                   ├── themes.xml                ← Temas y estilos de la app
│                   └── ...
└── settings.gradle.kts
```

## Contribuciones

Cualquier mejora o sugerencia es bienvenida. Puedes abrir un _issue_ o enviar un _pull request_. El proyecto está pensado para escalarse; nuevas funcionalidades deben agregarse siguiendo la misma estructura de capas (casos de uso en `domain`, implementación en `data` y vistas en `presentation`).

## Licencia

Este proyecto se distribuye bajo la licencia MIT. Consulta el archivo `LICENSE` para más detalles.
