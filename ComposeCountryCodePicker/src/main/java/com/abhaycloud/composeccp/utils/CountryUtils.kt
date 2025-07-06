package com.abhaycloud.composeccp.utils

import java.util.Locale

object CountryUtils {
    private val deviceCountry: String
        get() = Locale.getDefault().country

    /**
     * Returns the country that matches the current device's country code.
     * If no match is found, returns the first country in the list as a fallback.
     */
    fun getDeviceCountry(): CountryModel {
        return CountryData.countries.find { it.code == deviceCountry }
            ?: CountryData.countries[0]
    }

    /**
     * Extension function on String to convert a country code to a CountryModel.
     * If the code is not found, returns the first country in the list as a fallback.
     */
    fun String.toCountryModel(): CountryModel {
        return CountryData.countries.find { it.code == this }
            ?: CountryData.countries[0]
    }
}