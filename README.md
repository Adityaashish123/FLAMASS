# WeatherTrack - Android Weather Monitoring App

**WeatherTrack** is an Android application that allows users to track daily weather stats in their city. It fetches weather data (temperature, humidity, and condition) from a mock API or static JSON file, stores the data locally every 6 hours using Room, and displays a summary view showing temperature trends over the past week. The app is built using Java and follows the MVVM or Clean Architecture pattern.

---

## 📦 Feature Requirements

### 🔄 Fetch Weather
- Get weather data (temperature, humidity, condition) from a mock API or static JSON.
- Each data fetch is saved locally using Room database with a timestamp.

### 🔁 Auto Background Sync
- Uses WorkManager to schedule a sync job every 6 hours that fetches and saves the latest weather.
- Users can also manually refresh the weather data via a button in the app.

### 📊 Weekly Summary Screen
- Displays a graph or list of temperature changes over the past 7 days.
- Users can click on a specific day to view detailed weather information for that day.

---

## 🏗️ App Architecture

- Built using Java (no Kotlin).
- Follows MVVM or Clean Architecture.

**Layers:**
- UI (Activities/Fragments)
- ViewModel
- Repository
- Data Source (Room, mock API)

---

## ⚠️ Error Handling

Displays user-friendly error messages in the following scenarios:
- a) No internet connection  
- b) API errors  
- c) Local database errors  

---

## 🛠️ Tech Stack

- **Java**
- **Room** for local database storage
- **WorkManager** for background syncing
- **LiveData or Observables** for reactive UI updates
- **No external libraries for graphs** (custom drawing or simple list-based UI)

---

## 📝 Instructions

1. Open the project in Android Studio.
2. Ensure that the static JSON or mock API endpoint is correctly set up.
3. Run the application on a device or emulator.
4. To test background sync, wait or trigger WorkManager manually via developer options.
