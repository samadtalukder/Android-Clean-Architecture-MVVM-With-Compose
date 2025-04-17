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
- **Logging:** Timber.
- **Parsing:** KotlinX serialization.
- **Testing Framework:**
  - MocckK 
  - Espresso 
  - Turbine
  - Google Truth


## 🏗️ Architecture

The project follows the MVVM (Model-View-ViewModel) architecture pattern to separate concerns and improve testability and maintainability.

### Directory Structure
 ```
├── app/
│   ├── src/
│   │   ├── main/
│   │   │   ├── java/com/
│   │   │   │   ├── data/            # Data layer
│   │   │   │   │   ├── local/       # Local database
│   │   │   │   │   ├── remote/      # Network API
│   │   │   │   │   └── repository/  # Data repositories
│   │   │   ├── domain/              # Business logic
│   │   │   │   ├── model/           # Domain models
│   │   │   │   ├── usecase/         # Business logic
│   │   │   │   └── repository/      # Repository interfaces
│   │   │   └── presentation/        # UI components
│   │   │       ├── viewmodel/       # ViewModels
│   │   │       └── ui/              # Compose UI
│   │   │   └── utils/               # Utilites
│   │   │       └──   
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

## CI/CD Dependencies

This project utilizes several third-party tools to automate and optimize the Continuous Integration and Continuous Delivery (CI/CD) pipeline. These tools are **not included** in the final packaged application.

---

### 🔧 Fastlane

- **Website**: [https://fastlane.tools/](https://fastlane.tools/)
- **Purpose**: Automates the building, signing, and distribution of applications.
- **License**: MIT License

Fastlane enables seamless deployment of Android builds to testing services (e.g., Firebase App Distribution) or directly to the Play Store. It's also used for managing versioning and screenshots during release cycles.

---

### ✅ Kover

- **Repository**: [https://github.com/Kotlin/kotlinx-kover](https://github.com/Kotlin/kotlinx-kover)
- **Purpose**: Kotlin code coverage reporting toolset.
- **License**: Apache License 2.0

Kover provides metrics and visual reports for test coverage, helping to ensure the codebase is thoroughly tested and adheres to quality standards.



