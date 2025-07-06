package com.abhaycloud.composeccp

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import com.abhaycloud.composeccp.utils.CountryModel
import kotlinx.coroutines.launch

/**
 * A customizable Country Picker composable for Jetpack Compose applications.
 *
 *   This composable offers several customization options:
 * - The main field appearance can be fully customized via the content parameter
 * - Individual country items in the bottom sheet can be customized
 * - The search field in the bottom sheet can be customized
 *
 * @param selectedCountry The currently selected country to display in the field.
 * @param onCountrySelected Callback that is invoked when a new country is selected from the bottom sheet.
 *        It provides the selected [CountryModel] as a parameter.
 * @param bottomSheetCountryItem Optional composable to define the appearance of each country item in the
 *        bottom sheet list. Defaults to [DefaultCountryItem].
 * @param searchField Optional composable to define the appearance and behavior of the search field in the
 *        bottom sheet. Defaults to [DefaultSearchField].
 * @param content Optional composable to define the appearance of the country picker field itself.
 *        It receives the selected [CountryModel] (giving access to code, name, dialCode, and icon) and
 *        a click handler as parameters. Defaults to [DefaultCountryPickerField].
 *
 * @see CountryModel
 */
@Composable
fun CountryPickerField(
    selectedCountry: CountryModel,
    onCountrySelected: (CountryModel) -> Unit,
    bottomSheetCountryItem: @Composable (CountryModel) -> Unit = { country ->
        DefaultCountryItem(country = country)
    },
    searchField: @Composable (searchQuery: String, onValueChange: (String) -> Unit) -> Unit = { searchQuery, onValueChange ->
        DefaultSearchField(searchQuery, onValueChange)
    },
    content: @Composable (country: CountryModel, onClick: () -> Unit) -> Unit = { country, onClick ->
        DefaultCountryPickerField(country = country, onClick = onClick)
    }
) {
    var showBottomSheet by remember { mutableStateOf(false) }
    val scope = rememberCoroutineScope()

    content(selectedCountry) {
        showBottomSheet = true
    }

    AnimatedVisibility(visible = showBottomSheet) {
        CountryPickerBottomSheet(
            onDismiss = { scope.launch { showBottomSheet = false } },
            isVisible = showBottomSheet,
            countryItem = bottomSheetCountryItem,
            searchField = searchField,
            onCountrySelected = {
                onCountrySelected(it)
                scope.launch {
                    showBottomSheet = false
                }
            }
        )
    }
}