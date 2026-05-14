# TravelApp

## App Overview

The app has 2 screens for creating and viewing a packing list. Users can add items with name, category, quantity, and comments, then view items where quantity ≥ 2.

## Features

### Screen One - Add Items
- Input fields for Item Name, Category, Quantity, and Comments
- Add To Packing List button: Saves item if all fields are filled
- Go To Screen Two button: Navigates to the packing list view
- Exit App button: Closes the app
- Error Handling: Prints "ERROR: Empty fields" to logcat if any field is empty. Valid items print "Item Added"

### Screen Two - View List
- Display Packing List button: Logs "Displaying Full Packing List" for debugging
- Show Quantity ≥ 2 button: Logs "Displaying Quantity Above 2"
- List View: Uses `LazyColumn` to display items with quantity 2 or more in cards
- Back To Main Screen button: Returns to Screen One

## Error Handling
- Input validation prevents adding items with empty fields
- Invalid quantity input will crash on `toInt()` - add `try-catch` if needed for robustness
- All actions use `println()` for logging to demonstrate code flow

## Screenshots


## Setup Instructions

1. Clone the repo
   https://github.com/mohlalakgopotso442-glitch/TravelApp
2. Open in Android Studio
   - File > Open > Select project folder
3. Sync Gradle
   - Ensure Gradle 8.6, AGP 8.5.0, Kotlin 1.9.22
4. Run
   - Use an emulator or device with API 24+
   - Click Run > Run 'app'

## Tech Stack
- Language: Kotlin
- UI: Jetpack Compose
- Min SDK: 24
- Target SDK: 34
- Logging: `println()` used for debugging and demonstration

Author: Kgopotso


