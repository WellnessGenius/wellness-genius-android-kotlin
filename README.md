# Wellness Genius Android (Kotlin)

Native Android application for the Wellness Genius platform, built with Kotlin.

## Features

- **Kotlin**: Modern, concise programming language for Android
- **Firebase Integration**: Authentication and cloud services
- **Health Connect**: Integration with Android's health data platform
- **MVVM Architecture**: Clean separation of concerns with ViewModel and LiveData
- **Dependency Injection**: Hilt for simplified DI
- **Coroutines**: Asynchronous programming with Kotlin Coroutines
- **Room Database**: Local data persistence
- **Material Design**: Modern, responsive UI following Material guidelines

## Quick Start

### Prerequisites

- Android Studio Arctic Fox or newer
- JDK 11
- Android SDK with Android 12 (API 31) or newer

### Installation

1. Clone the repository:

```bash
git clone https://github.com/WellnessGenius/wellness-genius-android-kotlin.git
cd wellness-genius-android-kotlin
```

2. Open the project in Android Studio.

3. Create a Firebase project and download the `google-services.json` file.

4. Place the `google-services.json` file in the app directory.

5. Build and run the project.

## App Architecture

The application follows the MVVM (Model-View-ViewModel) architecture pattern with the following components:

- **View**: Activities and Fragments for UI
- **ViewModel**: Handles UI-related data and logic
- **Repository**: Single source of truth for data
- **Service**: Interfaces with external data sources (API, Health Connect)

## Health Connect Integration

The application uses Health Connect to access health and fitness data. Users must grant permissions for the app to access this data.

## Testing

Run the unit tests with:

```bash
./gradlew test
```

Run the instrumented tests with:

```bash
./gradlew connectedAndroidTest
```
