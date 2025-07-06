# 🌍 ComposeCountryCodePicker

[![](https://jitpack.io/v/Abhay-cloud/ComposeCountryCodePicker.svg)](https://jitpack.io/#Abhay-cloud/ComposeCountryCodePicker)
[![License](https://img.shields.io/github/license/Abhay-cloud/ComposeCountryCodePicker)](LICENSE)
[![Platform](https://img.shields.io/badge/platform-android-blue)](https://developer.android.com/jetpack/compose)

 **A customizable Country Picker component for Jetpack Compose.**

---

## ✨ Features

* 🎨 Fully customizable UI components:

  * Picker field layout
  * Country list item appearance
  * Search field
* 🔍 Search countries by **name** or **dial code**
* 📥 Provides detailed info about the selected country:

  * **Name**, **ISO code**, **dial code**, and **flag image**

---

## 📦 Installation

Add JitPack to your root `settings.gradle`:

```kotlin
dependencyResolutionManagement {
    repositories {
        ...
        maven { url 'https://jitpack.io' }
    }
}
```

Then add the dependency:

```kotlin
dependencies {
    implementation("com.github.Abhay-cloud:ComposeCountryCodePicker:1.1.1")
}
```

---

## 🚀 Quick Start

You can get started with the **default UI** with just a few lines:

```kotlin
var selectedCountry by remember { mutableStateOf(CountryUtils.getDeviceCountry()) }

CountryPickerField(
    selectedCountry = selectedCountry,
    onCountrySelected = { selectedCountry = it }
)
```

This will show a country picker with built-in styling for the field, bottom sheet, search bar, and country list items.

---

## 🧩 Customization

Need more control? You can override individual parts of the UI using your own composables:

```kotlin
CountryPickerField(
    selectedCountry = selectedCountry,
    onCountrySelected = { selectedCountry = it },

    content = { country, onClick ->
        CustomField(country = country, onClick = onClick)
    },

    searchField = { query, onQueryChange ->
        CustomSearchField(query = query, onQueryChange = onQueryChange)
    },

    bottomSheetCountryItem = { country ->
        CustomCountryListItem(country = country)
    }
)
```

---

## 📘 CountryModel

The picker uses a simple data model:

```kotlin
data class CountryModel(
    val code: String,      // e.g., "US", "FR"
    val name: String,      // e.g., "United States", "France"
    val dialCode: String,  // e.g., "+1", "+33"
    val flagEmoji: String  // e.g., "🇺🇸", "🇫🇷"
)
```

> You may adapt this model to support flag drawables or images as needed.

---

## 📚 Country Utilities

The library includes helper functions like `getDeviceCountry()`, which returns the `CountryModel` that matches the current device's country code—useful for setting a default selection. You can also convert a country code string (like `"US"` or `"IN"`) directly into a `CountryModel` using the `toCountryModel()` extension function. Both methods provide sensible fallbacks if the country code isn’t found.

---

## 🧑‍💻 Contributing

Contributions are welcome!  
If you'd like to contribute:

1. Fork this repo
2. Create a feature branch
3. Submit a pull request

---

## 📄 License

This project is licensed under the [MIT License](LICENSE).

---
