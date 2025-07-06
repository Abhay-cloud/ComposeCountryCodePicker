package com.abhaycloud.composeccp.utils

import java.util.Locale

object CountryUtils {
    private val deviceCountry: String
        get() = Locale.getDefault().country

    fun CountryData.getLocaleCountry(): CountryModel {
        return this.countries.find { country ->
            country.code == deviceCountry
        } ?: countries[0]
    }

    fun String.getCountryModel(): CountryModel {
        return CountryData.countries.find {
            it.code == this
        } ?: CountryData.countries[0]
    }
}