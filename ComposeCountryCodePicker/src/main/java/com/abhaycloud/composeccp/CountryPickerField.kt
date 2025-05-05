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