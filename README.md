# 💧 WaterBuddy

WaterBuddy is a water intake tracking Android application developed using **Jetpack Compose**, **MVVM**, **Room**, and **Hilt**.
It helps users track their daily water consumption, review intake history, and stay hydrated with an intuitive and lightweight user experience.

---

## 📱 Features

- Track daily water intake (e.g., 250ml, 500ml, 750ml, 1L)
- View historical water consumption records
- Automatically resets daily intake data
- Fully localized string management
- Persistent local storage with Room
- Clean UI built with Jetpack Compose
- Clean Architecture with clear separation of concerns

---

## 🏗️ Architecture

The project follows **Clean Architecture** with **MVVM** (Model-View-ViewModel) principles. Key layers:

presentation/
├── home/               # HomeScreen & HomeViewModel
├── history/            # HistoryScreen & HistoryViewModel
├── navigation/         # Navigation setup (BaseScreen, NavGraph)

domain/
├── model/              # WaterIntake domain model
├── repository/         # WaterRepository interface
├── usecase/            # Use cases (Add, GetToday, GetAll, Clear)

data/
├── local/
│   ├── db/             # Room database (AppDatabase)
│   ├── dao/            # WaterIntakeDao
│   └── entity/         # WaterIntakeEntity (Room Entity)
├── mapper/             # Entity <-> Domain mappers
├── repository/         # WaterRepositoryImpl

di/
└── AppModule.kt        # Hilt Dependency Injection

utils/
└── DateUtils.kt        # Timestamp formatter (Turkish locale)

---

## 🧰 Tech Stack

| Layer        | Tech                                      |
|--------------|-------------------------------------------|
| UI           | Jetpack Compose, Material3                |
| Architecture | MVVM, Clean Architecture                  |
| Dependency Injection | Hilt (Dagger)                    |
| Database     | Room with DAO                             |
| Language     | Kotlin                                    |
| Navigation   | Navigation Compose                        |
| Date Format  | `SimpleDateFormat` with Turkish locale    |

---