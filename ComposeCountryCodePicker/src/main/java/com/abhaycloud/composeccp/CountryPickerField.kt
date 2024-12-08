package com.abhaycloud.composeccp

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.BorderStroke
import androidx.compose.material3.Card
import androidx.compose.material3.CardColors
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.Shape
import com.abhaycloud.composeccp.utils.CountryModel
import kotlinx.coroutines.launch

@Composable
fun CountryPickerField(
    selectedCountry: CountryModel,
    onCountrySelected: (CountryModel) -> Unit,
    fieldColors: CardColors = CountryPickerFieldDefaults.fieldColors(),
    fieldShape: Shape = CountryPickerFieldDefaults.fieldShape(),
    fieldBorderStroke: BorderStroke? = CountryPickerFieldDefaults.fieldBorderStroke(),
    countryItem: @Composable (CountryModel) -> Unit = { country ->
        DefaultCountryItem(country = country)
    },
    content: @Composable (CountryModel) -> Unit = { country ->
        DefaultCountryPickerField(country = country)
    }
) {
    var showBottomSheet by remember { mutableStateOf(false) }
    val scope = rememberCoroutineScope()

    Card(
        shape = fieldShape,
        colors = fieldColors,
        border = fieldBorderStroke,
        onClick = {
            showBottomSheet = true
        }
    ) {
        content(selectedCountry)
    }

    AnimatedVisibility(visible = showBottomSheet) {
        CountryPickerBottomSheet(
            onDismiss = { scope.launch { showBottomSheet = false } },
            isVisible = showBottomSheet,
            countryItem = countryItem,
            onCountrySelected = {
                onCountrySelected(it)
                scope.launch {
                    showBottomSheet = false
                }
            }
        )
    }

}