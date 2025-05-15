# Android Clean Architecture With MVVM Using Jetpack Compose


## 🚀 Tech Stack

- **Language:** Kotlin.
- **Architecture:** MVVM with Clean Architecture.
- **Dependency Injection:** Hilt.
- **Asynchronous Programming:** Kotlin Coroutines.
- **Jetpack Compose:** Used for building UI components declarative.
- **Jetpack Components:**
  - ViewModel 
  - LiveData 
  - Room
  - Navigation
- **Networking:** Retrofit2 & OkHttp3:.
- **Image loading:** Coil.
- **Parsing:** Gson.
- **Testing Framework:**
  - MocckK 
  - Espresso
  - Google Truth


## 🏗️ Architecture

The project follows the MVVM (Model-View-ViewModel) architecture pattern to separate concerns and improve testability and maintainability.

### Directory Structure
 ```
app/
├── data/                # Data Layer
│   ├── datasource/
│   ├── remote/
│   │   ├── model/
├── di/                  # Dependency Injection
│   ├── 
├── domain/              # Domain Layer
│   ├── models/          
│   ├── repository/     
│   └── usecase/         
├── ui/                  # UI Layer
│   ├── common/
│   │   ├── components/  
│   │   ├── theme/       
│   └── features/        # Features organized by screens
│       ├── home/
│   └── nav/
│   └── viewmodel/
└── utils/               # App utilities
 ```

## 🚀 Getting Started

## Compatibility
- **Minimum SDK:** 24
- **Target SDK:** 35
- **Device Types Supported:** Mobile
- **Orientations Supported:** Portrait

### 📌 Prerequisites
- **Android Studio Giraffe** (or latest)
- **Java 11+** installed
- **Gradle 8+**
- **Kotlin 1.7++**

## 📦 Clone the repository

```sh
git clone https://github.com/samadtalukder/Android-Clean-Architecture-MVVM-With-Compose
```

### 🏗️ Build & Run
- Open in **Android Studio**
- Run Sync Gradle
- Run the app on an emulator or physical device 🚀

## 🤝 Contribution Guidelines
1. Fork the repository
2. Create a feature branch
   ```sh
   git checkout -b branchName
   ```
3. Commit your changes
4. Push to the branch
   ```sh
   git push origin branchName
   ```
5. Open a Pull Request

## Coding Standards
- Follow **Kotlin** Coding Conventions
- Write clear, documented code
- Maintain 80% test coverage
- Use meaningful variable and function names

## Demo

<img src="demo/app_demo.gif" width="200"/>



