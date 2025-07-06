package com.abhaycloud.composeccp.utils

/**
 * Data class representing a country in the country picker.
 *
 * This model encapsulates all information needed to display and identify a country
 * within the CountryPicker component.
 *
 * @property code The ISO 3166-1 alpha-2 country code (e.g., "US", "IN").
 * @property name The full country name in English (e.g., "United States", "India", "United Kingdom").
 * @property dialCode The international dialing code including the plus sign (e.g., "+1", "+91", "+44").
 * @property icon Resource ID reference to the country's flag drawable resource.
 *
 * @see CountryPickerField
 */
data class CountryModel(
    val code: String,
    val name: String,
    val dialCode: String,
    val icon: Int
)